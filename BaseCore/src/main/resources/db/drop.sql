drop table if exists cm_cd_dtl CASCADE; 
drop table if exists cm_cd_grp CASCADE; 
drop table if exists cm_critical_log CASCADE; 
drop table if exists cm_menu CASCADE; 
drop table if exists cm_menu_dtl CASCADE; 
drop table if exists cm_menu_dtl_role_map CASCADE; 
drop table if exists cm_noti CASCADE; 
drop table if exists cm_noti_user_map CASCADE; 
drop table if exists cm_org CASCADE; 
drop table if exists cm_org_user_map CASCADE; 
drop table if exists cm_role CASCADE; 
drop table if exists cm_role_chg_log CASCADE; 
drop table if exists cm_role_menu_map CASCADE; 
drop table if exists cm_user CASCADE; 
drop table if exists cm_user_acces_log CASCADE; 
drop table if exists cm_user_alow_ip CASCADE; 
drop table if exists cm_user_bookmark CASCADE; 
drop table if exists cm_user_pwd CASCADE; 
drop table if exists cm_user_role_map CASCADE;
drop table if exists cm_user_relat CASCADE;  

drop table if exists td_quiz_work_use CASCADE; 
drop table if exists td_worker_map CASCADE; 
drop table if exists td_quiz CASCADE;
drop table if exists td_quiz_user_map CASCADE; 
drop table if exists td_todo CASCADE; 
drop table if exists td_todo_checker_map CASCADE; 
drop table if exists td_work_setle_map CASCADE;
drop table if exists td_setle CASCADE;
drop table if exists td_work CASCADE;
drop table if exists td_checker_map CASCADE;
drop table if exists td_point CASCADE;
drop table if exists td_checker_worker_map CASCADE;

drop sequence if exists seq_cm_critical_log;
drop sequence if exists seq_cm_menu;
drop sequence if exists seq_cm_menu_dtl;
drop sequence if exists seq_cm_noti_user_map;
drop sequence if exists seq_cm_org;
drop sequence if exists seq_cm_role;
drop sequence if exists seq_cm_role_chg_log;
drop sequence if exists seq_cm_user;
drop sequence if exists seq_cm_user_acces_log;
drop sequence if exists seq_cm_user_alow_ip;

drop sequence if exists seq_td_quiz;
drop sequence if exists seq_td_todo;
drop sequence if exists seq_td_setle;
drop sequence if exists seq_td_work;
drop sequence if exists seq_td_point;

DROP TABLE QRTZ_FIRED_TRIGGERS;
DROP TABLE QRTZ_CRON_TRIGGERS;
DROP TABLE QRTZ_SIMPROP_TRIGGERS;
DROP TABLE QRTZ_SIMPLE_TRIGGERS;
DROP TABLE QRTZ_SCHEDULER_STATE;
DROP TABLE QRTZ_PAUSED_TRIGGER_GRPS;
DROP TABLE QRTZ_TRIGGERS;
DROP TABLE QRTZ_JOB_DETAILS;
DROP TABLE QRTZ_CALENDARS;
DROP TABLE QRTZ_BLOB_TRIGGERS;
DROP TABLE QRTZ_LOCKS;

DROP TABLE  BATCH_STEP_EXECUTION_CONTEXT IF EXISTS;
DROP TABLE  BATCH_JOB_EXECUTION_CONTEXT IF EXISTS;
DROP TABLE  BATCH_STEP_EXECUTION IF EXISTS;
DROP TABLE  BATCH_JOB_EXECUTION_PARAMS IF EXISTS;
DROP TABLE  BATCH_JOB_EXECUTION IF EXISTS;
DROP TABLE  BATCH_JOB_INSTANCE IF EXISTS;
DROP SEQUENCE  BATCH_STEP_EXECUTION_SEQ IF EXISTS;
DROP SEQUENCE  BATCH_JOB_EXECUTION_SEQ IF EXISTS;
DROP SEQUENCE  BATCH_JOB_SEQ IF EXISTS;

drop sequence if exists HIBERNATE_SEQUENCE;
DROP TABLE "flyway_schema_history";