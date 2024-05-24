#Instalacion
Esta configurado para que ecuche en el puerto 9002



# Crear imagen docker
 
```shell
docker build -t payara-hello .

```

# accreditation
sistema de accreditaciones



#Execute docker compose
docker-compose up -d

java -jar -Xmx512m target/accreditation.jar 



Para ejecutar uberjar
java -jar payara-micro-6.2024.5.jar --deploy accreditation.war --outputUberJar accreditation.jar


#Ejecutar el war


java -jar /home/avbravo/software/payara/c.jar  --deploy /home/avbravo/NetBeansProjects/u/utp/sftdynamics/accreditationdynamic/target/accreditation.war --noHazelcast --logo --port 9002


#Crear  el Uberjar
java -jar   /home/avbravo/software/payara/payara-micro-6.2024.5.jar --deploy /home/avbravo/NetBeansProjects/u/utp/sftdynamics/accreditationdynamic/target/accreditation.war --outputUberJar /home/avbravo/Descargas/accreditation.jar 



# Ejecutar JAR

Use --noHazelcast en lugar de --nocluster
 
 java -jar -Xmx512m accreditation.jar --noHazelcast --logo --port 9002 >>log.txt


## Mediante maven

Crear el war
```shell

mvn clean verify

cd target

````


Ejecutar 

```shell

mvn clean verify payara-micro:start

cd target

````

## Crear el uber jar

De esta manera el url solo tendria el ip , util para microservicios

```shell

mvn clean verify payara-micro:bundle

cd target

java -jar accreditation-bundle.jar
````

#@ViewEntity
Utiliza vistas para mejorar el rendimiento de muchas operaciones


## Migracion a columnas

 # Pasos
 
 1. Consultar cuantos proyectos existen
 
 2. Exportar un total de archivos correspondientes a la totalidad de proyectos
 
 3. Importar archivo a archivo
 
 4.
 # Exportar 
 
db.tarjeta_1.remove(  { idproyecto: { $ne:NumberLong(1) } } )

db.tarjeta_2.remove(  { idproyecto: { $ne:NumberLong(2) } } )

db.tarjeta_3.remove(  { idproyecto: { $ne:NumberLong(3) } } )
db.tarjeta_4.remove(  { idproyecto: { $ne:NumberLong(4) } } )
db.tarjeta_5.remove(  { idproyecto: { $ne:NumberLong(5) } } )
db.tarjeta_6.remove(  { idproyecto: { $ne:NumberLong(6) } } )
db.tarjeta_7.remove(  { idproyecto: { $ne:NumberLong(7) } } )
db.tarjeta_8.remove(  { idproyecto: { $ne:NumberLong(8) } } )
db.tarjeta_9.remove(  { idproyecto: { $ne:NumberLong(9) } } )
db.tarjeta_10.remove(  { idproyecto: { $ne:NumberLong(10) } } )
db.tarjeta_11.remove(  { idproyecto: { $ne:NumberLong(11) } } )
db.tarjeta_12.remove(  { idproyecto: { $ne:NumberLong(12) } } )