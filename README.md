# TallerCloud


Pasos para el correcto funcionamiento del proyecto : 

## BackEnd

#### Paso 1 

Descargar el repositorio Taller Cloud, donde se encontrará dos carpetas llamadas backend y frontend , ademas del modelo de bases de datos. 

#### Paso 2 
Abrimos el modelo de la base de datos Equipos.mwb y cambiamos el persistence.xml que esta ubicado en el directorio **src/Backend/src/main/resources/META-INF/** por las configuraciones de su usuario, password y nombre de la base de datos creada por usted antes. 

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
  <persistence-unit name="echoPU">
    <class>beans.Equipo</class>
    <properties>      
      <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/Equipos?zeroDateTimeBehavior=convertToNull"/>
      <property name="javax.persistence.jdbc.user" value="root"/>
      <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
      <property name="javax.persistence.jdbc.password" value="password"/>
    </properties>
  </persistence-unit>
</persistence>
```
#### Paso 2 
Ir hasta la carpeta donde esta ubicado el backend y escribir el siguiete comando para ejecutarlo.

```
mvn appengine:devserver
```

### Paso 3
Esperar a que el proyecto suba correctamente y cuando esto suceda ir en el navegador a la ruta 

```
localhost:8080/_ah/api/explorer
```
y probar los endpoints con el API de google.


## FrontEnd

Configuracion para el correcto funcionamiento del frontend

### Paso 1

Como ya se ha descargado todas las carpetas del repositorio se dbe ubicar dentro del repositorio frontEnd.

### Paso 2

Seguido de esto se debe instalar npm install y ya adentro de esta carpeta se corre el comando npm start

### Paso 3

cuando el proyecto suba correctamente se preba el correcto funcionamiento de los servicios con el frontend

### Paso 4

Debe tenerse encuenta que dentro del render estan mostrandose cada vista segun el servicio, es decir, dentro del metodo render se llama a cada uno de los metodos para poder desplegarlos en la vista.

```
ReactDOM.render(
  //<App />,
  //document.getElementById('root')
 // <AgregarEquipo />,
  //document.getElementById('root2')
  <EliminarEquipo />,
  //document.getElementById('root3')
  //<EditarEquipo />,
  document.getElementById('root4')
);
```
