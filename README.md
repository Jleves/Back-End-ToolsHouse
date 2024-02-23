# ToolHouse - Proyecto Integrador

Este proyecto es una aplicación de booking desarrollada con SpringBoot

### Tecnologías utilizadas
 - Spring Boot
 - Spring Data JPA
 - Spring Security
 - MySQL
 - Lombok
 - Maven

### Funcionalidades
 - Reserva de herramientas de construcción
 - Administración de inventario
 - Visualización de disponibilidad de herramientas

### Configuración de la Base de Datos

La aplicación utiliza MySQL para almacenar datos. Asegúrate de configurar correctamente la base de datos antes de ejecutar la aplicación

> application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/DB_ToolsToHome
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```
> [!IMPORTANT]
> Recuerda configurar la base de datos según las necesidades antes de ejecutar la aplicación.

### Ejecución del proyecto
Para ejecutar el proyecto localmente es necesario seguir los siguientes pasos:
1. Clonar el repositorio
2. Configurar la base de datos como se describe arriba
3. Ejecutar la aplicación usando Maven o el IDE que estés utilizando
  ```
  mvn spring-boot:run
  ```
4. Accender a la aplicación desde tu navegador web a la dirección:
```
http://localhost:8080
```
