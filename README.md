# G5_alura_one_hotel_alura_spring_mvc
![one](https://github.com/ccortes66/G5_alura_one_hotel_alura/assets/63931313/dbdde68a-7557-4914-9df1-b80669045e0f)

## Tecnologías
- MariaDb(Base De Datos)
- Spring Boot MVC
- Java Template Engine(jte)(parte Visual)
- Java JPA (Operaciones a base de datos)
- lombok(Generar Getters y Setters)
- Jdk version 17(amazon corretto)
- Spring Security
- Redis Lettuce caching
    
## Diagrama Físico DDBB
![DiagramaFisico](https://github.com/ccortes66/G5_alura_one_hotel_alura/assets/63931313/9e2ebf88-f696-4a4b-b30f-5701130edd3c)


## Docker-Compose 
```docker

version: '3.8'
services:
  mariadb:
    image: mariadb:10.11.4
    container_name: mariadb
    restart: unless-stopped
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: su_contraseña
      MYSQL_DATABASE: hotel_alura
      MYSQL_USER: su_usuario
      MYSQL_PASSWORD: su_contraseña
    volumes:
      - mariadb_data:/var/lib/mysql

redis:
    image: redis:7.2.1-alpine3.18
    container_name: redis
    restart: unless-stopped
    ports:
      - "6379:6379"
    volumes:
      - /etc/localtime:/etc/localtime:ro

volumes:
  mariadb_data:

```
## Habilitar privilegios en MariaDB
```bash
   $ docker exec -it mariadb bash
   $ mysql -u root -p
   $ GRANT ALL PRIVILEGES ON * . * TO 'su_usuario'@'%'
   $ FLUSH PRIVILEGES
```

## Run Jar File
```bash
   $ java -jar springboottres-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```


## Recomendaciones
- Instalar docker y docker-compose, copiar script apartado docker compose, generar nuevo archivo llamado docker-compose.yml guardarlo, abir la terminal, buscar el directorio donde se generó el archivo, escriben el comando docker-compose up -d para levantar el contenedor, docker-compose down para parar el contenedor.
- Registrarse en h-captcha es gratis para generar el secret y colocar en la variable de entorno  
- Registrar el primer empleado esto en el fin de crear los métodos de pago, habitación tipo y habitación teminado en direccionWeb:8081/public/empleado 
- Si tiene errores con h-captcha, se recomienda colocar un host diferente a localhost, en Linux editan el archivo /etc/hosts(permisos admin) nano o vin colocan 
```bash
   127.0.0.1 hotelalura.com
```
## Variables de Entorno
- Registro variables de entorno WSL2, .bashrc, .zshrc
```bash
export USER_DB="SU_USUARIO"
export PASS_DB="SU_PASSWORD"
export REMOTE_DB="SU_IP_SERVIDOR"
export HOSTNAME_DB="jdbc:mariadb://SU_IP_SERVIDOR:3306/SU_BASE_DE_DATOS?createDatabaseIfNotExist=true"
export secret="SECRET_GENERADO_H-CAPTCHA"

```

## Interface Usuario
Interface Cliente


https://github.com/ccortes66/G5_alura_one_hotel_alura/assets/63931313/f3d8a71b-3bc0-4099-9e7d-4afca899a5f1



Interface Empleado

https://github.com/ccortes66/G5_alura_one_hotel_alura/assets/63931313/82569c4a-8438-4653-9d72-5d8d32eb6f8f
