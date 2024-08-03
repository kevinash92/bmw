psql -U "postgres" -p "5432" -d "bmw_dev_db" -c "CREATE SCHEMA bmw_dev01 AUTHORIZATION pg_database_owner;"
psql -U "postgres" -p "5432" -d "bmw_dev_db" -c "CREATE EXTENSION IF NOT EXISTS unaccent SCHEMA bmw_dev01;"
psql -U "postgres" -p "5432" -d "bmw_dev_db" -f /tmp/data_dev01.sql