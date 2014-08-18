@echo off

echo El archivo especificado esta a punto de restaurarse.
c:
cd /
cd xampp/mysql/bin
pause
 mysql -u root -p mysql < "E:\Estimulosuno\estimulos.sql"
mysql -u root -p mysql < "F:\Estimulosuno\estimulos.sql"
mysql -u root -p mysql < "G:\Estimulosuno\estimulos.sql"
mysql -u root -p mysql < "H:\Estimulosuno\estimulos.sql"
exit 