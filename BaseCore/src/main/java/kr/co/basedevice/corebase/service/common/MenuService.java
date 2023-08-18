package kr.co.basedevice.corebase.service.common;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import kr.co.basedevice.corebase.domain.cm.CmMenu;
import kr.co.basedevice.corebase.domain.cm.CmRole;
import kr.co.basedevice.corebase.domain.cm.CmRoleMenuMap;
import kr.co.basedevice.corebase.domain.code.Yn;
import kr.co.basedevice.corebase.dto.system.MenuInfoDto;
import kr.co.basedevice.corebase.dto.system.ParentMenuDto;
import kr.co.basedevice.corebase.dto.system.SaveMenuInfo;
import kr.co.basedevice.corebase.repository.cm.CmMenuRepository;
import kr.co.basedevice.corebase.repository.cm.CmRoleMenuMapRepository;
import kr.co.basedevice.corebase.repository.cm.CmRoleRepository;
import kr.co.basedevice.corebase.search.system.SearchMenu;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class MenuService {
	
	final private CmMenuRepository cmMenuRepository;
	final private CmRoleRepository cmRoleRepository;
	final private CmRoleMenuMapRepository cmRoleMenuMapRepository;
	
	/**
	 * 메뉴 조회는 모든 메뉴를 대상으로 하지만, 
	 * 검색 결과는 LeafMenu를 도출한 후
	 * 상위 메뉴를 재구성하면 목록을 만든다.  
	 * 
	 * @param searchMenuInfo
	 * @return
	 */
	public List<CmMenu> findByMenuList() {
		
		// 당연히 삭제된 것과 대시보드를 비롯하여 표시되지 않는 메뉴는 제외
		List<CmMenu> cmMenuList = cmMenuRepository.findByPrntYnAndDelYnOrderByPrntOrdAsc(Yn.Y, Yn.N);
		
		return cmMenuList;
	}

	/**
	 * 메뉴 삭제
	 * - 하위 메뉴가 없어야 삭제 가능
	 * 
	 * @param menuSeq
	 * @return
	 */
	public boolean removeMenu(Long menuSeq) {
		
		// 하위 메뉴 건수를 조회한다.
		Long cnt = cmMenuRepository.countByUpMenuSeqAndDelYn(menuSeq, Yn.N);
		
		if(cnt > 0L) {
			return false;
		}else {
			CmMenu cmMenu = cmMenuRepository.getById(menuSeq);
			
			cmMenu.setDelYn(Yn.Y);			
			cmMenuRepository.save(cmMenu);
			
			return true;
		}		
	}

	/**
	 * 메뉴 저장
	 * 
	 * @param cmMenu
	 * @return
	 */
	public boolean saveCmMenu(SaveMenuInfo saveMenuInfo, Long updatorSeq) {
		
		CmMenu cmMenu = null;
		if(ObjectUtils.isEmpty(saveMenuInfo.getMenuSeq())) {
			cmMenu = new CmMenu();
		}else {
			cmMenu = cmMenuRepository.getById(saveMenuInfo.getMenuSeq());
			List<CmRoleMenuMap> cmRoleMenuMapList = cmRoleMenuMapRepository.findByMenuSeqAndDelYn(saveMenuInfo.getMenuSeq(), Yn.N);
			if(cmRoleMenuMapList != null && !cmRoleMenuMapList.isEmpty()) {
				for(CmRoleMenuMap cmRoleMenuMap : cmRoleMenuMapList) {
					cmRoleMenuMap.setDelYn(Yn.Y);
				}
				cmRoleMenuMapRepository.saveAll(cmRoleMenuMapList);
			}			
		}
		
		cmMenu.setUpMenuSeq(saveMenuInfo.getUpMenuSeq());
		cmMenu.setMenuNm(saveMenuInfo.getMenuNm());
		cmMenu.setMenuPath(saveMenuInfo.getMenuPath());
		cmMenu.setMenuDesc(saveMenuInfo.getMenuDesc());
		cmMenu.setPrntOrd(saveMenuInfo.getPrntOrd());
		cmMenu.setIConInfo(saveMenuInfo.getIConInfo());
		cmMenu.setPrntYn(saveMenuInfo.getPrntYn());
		cmMenu.setCmScrenYn(saveMenuInfo.getCmScrenYn());
		cmMenu.setDelYn(Yn.N);
		
		CmMenu saveMenu = cmMenuRepository.save(cmMenu);
		
		if(saveMenuInfo.getRoleSeqList() != null && !saveMenuInfo.getRoleSeqList().isEmpty()) {
		  for(Long roleSeq : saveMenuInfo.getRoleSeqList()) {
			  CmRoleMenuMap cmRoleMenuMap = new CmRoleMenuMap();
			  cmRoleMenuMap.setMenuSeq(saveMenu.getMenuSeq());
			  cmRoleMenuMap.setRoleSeq(roleSeq);
			  cmRoleMenuMap.setDelYn(Yn.N);
			  
			  cmRoleMenuMapRepository.save(cmRoleMenuMap);
		  }	
		}
		
		return true;
	}

	/**
	 * 메뉴 조회
	 * 
	 * @param searchMenu
	 * @return
	 */
	public List<MenuInfoDto> findBySearch(SearchMenu searchMenu) {
		List<MenuInfoDto> menuInfoDtoList = cmMenuRepository.findBySearch(searchMenu);
		
		if(menuInfoDtoList != null && !menuInfoDtoList.isEmpty()) {
			for(MenuInfoDto menuInfoDto : menuInfoDtoList) {
				// 역할 코드 
				List<CmRole> cmRoleList = cmRoleRepository.findByMenuSeq(menuInfoDto.getMenuSeq());
				menuInfoDto.setCmRoleList(cmRoleList);
				
				// 하위 메뉴 여부
				Long cnt = cmMenuRepository.countByUpMenuSeqAndDelYn(menuInfoDto.getMenuSeq(), Yn.N);
				if(cnt.longValue() > 0L) {
					menuInfoDto.setLeaf(false);
				}else{
					menuInfoDto.setLeaf(true);
				}
			}			
		}
		
		return menuInfoDtoList;
	}

	/**
	 * 하위 메뉴가 없는 메뉴 목록
	 * 
	 * @return
	 */
	public List<ParentMenuDto> findByParentMenuList() {
		
		// 하위 메뉴가 있는 것만 조회해서...
		List<ParentMenuDto> menuInfoDtoList = cmMenuRepository.findByParentMenuList();
		
		if(menuInfoDtoList != null && !menuInfoDtoList.isEmpty()) {
			Map<Long, ParentMenuDto> parentMenuDtoMap = new HashMap<>(menuInfoDtoList.size());
			for(ParentMenuDto parentMenuDto : menuInfoDtoList) {
				parentMenuDtoMap.put(parentMenuDto.getMenuSeq(), parentMenuDto);
			}
			
			for(ParentMenuDto parentMenuDto : menuInfoDtoList) {
				if(parentMenuDto.getUpMenuSeq() == null) {
					continue;
				} 
				
				ParentMenuDto upMenu = parentMenuDtoMap.get(parentMenuDto.getUpMenuSeq());
				parentMenuDto.setUpMenu(upMenu);
			}
		}
		
		return menuInfoDtoList;
	}

}