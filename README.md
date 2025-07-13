# 🎮 Gestión de Videojuegos - Mi Primera API REST con Java, Spring Boot y MySQL

Este es un proyecto personal, desarrollado como mi **primera API REST** usando Java y Spring Boot, que permite gestionar videojuegos, jugadores y desarrolladoras mediante operaciones CRUD sobre una base de datos MySQL. 

---

## 🧰 Tecnologías utilizadas

- Java 17+
- Spring Boot
- MySQL
- Maven
- Docker & Docker Compose
- Git & GitHub

---

## 🚀 Descripción del proyecto

Este proyecto personal fue desarrollado como mi **primera API REST** usando Java y Spring Boot, con el objetivo de afianzar conceptos básicos y aprender buenas prácticas en el desarrollo backend.

La aplicación permite gestionar videojuegos, jugadores y desarrolladoras con operaciones CRUD sobre una base de datos MySQL.

A lo largo del proyecto fui aprendiendo sobre buenas prácticas que aún no están plenamente implementadas, como:

- La gestión avanzada de excepciones personalizadas (aunque aprendí su importancia, no fue aplicada aquí y queda pendiente para futuros proyectos).
- El uso adecuado de DTOs para separar la capa de datos.
- Mejora en el uso de Git y los flujos de trabajo con ramas y commits, que inicialmente fueron básicos pero que se fueron perfeccionando a medida que avanzó el proyecto.

Además, incorporé Docker y Docker Compose para facilitar el despliegue y la ejecución del backend y la base de datos en contenedores.

---

## 📋 Funcionalidades principales

- Listado de jugadores, juegos, desarrolladoras, desarrollado juego y compras.
- Creación, actualización y eliminación de registros  
- Consultas con filtros dinámicos  
- Gestión básica de errores a nivel controlador

---
 
## 🧪 Requisitos previos

- Docker instalado (incluye Docker Compose en versiones modernas)
(opcional) Java y Maven si decides ejecutar el proyecto fuera de Docker

---

## ⚙️ Cómo ejecutar el proyecto

🔒 **Recomendación:** Clona el repositorio en una carpeta local que no esté sincronizada con servicios en la nube (como Google Drive, OneDrive o Dropbox), para evitar problemas de permisos y conflictos con archivos.
Por ejemplo:  
`C:\Usuarios\TuUsuario\Proyectos\`

### Preparar archivo `.env`

Para facilitar la configuración de variables sensibles (como las credenciales de MySQL), el archivo `.env` **no está incluido** en el repositorio y está listado en `.gitignore`.

En su lugar, encontrarás un archivo llamado `.env.example` que contiene las variables necesarias con valores de ejemplo.

Para ejecutar el proyecto correctamente, sigue estos pasos:

1. Copia el archivo `.env.example` y renómbralo a `.env`  
   ```bash
   cp .env.example .env
2. Edita el archivo .env para ajustar las variables según tu entorno, como usuario, contraseña y puerto de MySQL.

### Levantar los contenedores con Docker Compose

1. Clonar el repositorio  
   ```bash
   git clone https://github.com/DavidSvq/App-Juegos.git
   cd App-Juegos
2. Construir la imagen Docker y levantar los contenedores con Docker Compose  
   ```bash
   docker compose up --build
3. La API estará disponible en `http://localhost:8080`
4. Puedes probar la API fácilmente desde tu navegador accediendo, por ejemplo, a:  
   `http://localhost:8080/jugadores`

   También puedes usar herramientas más avanzadas como `curl` o Postman para realizar solicitudes HTTP y probar los distintos endpoints.

---

## 📌 Estado del proyecto

Este proyecto está finalizado en su versión actual y fue creado principalmente como ejercicio de aprendizaje. 

Está diseñado con una estructura modular y escalable que facilitaría futuras mejoras o ampliaciones, aunque no tengo planes inmediatos de continuar desarrollándolo, salvo que surja alguna corrección o cambio de idea.

---

## 📝 Aprendizajes y mejoras futuras

- Primera experiencia real desarrollando una API REST con Spring Boot.  
- Comprensión progresiva de la importancia de gestionar excepciones de forma centralizada y personalizada.  
- Reconocimiento de buenas prácticas en la creación de DTOs y estructuración del código, con intención de implementarlas en próximos proyectos.  
- Uso inicial y mejora continua en el manejo de control de versiones con Git, incluyendo flujos de trabajo con ramas.  
- Contenerización con Docker para facilitar pruebas y despliegues.

---

¡Gracias por revisar mi proyecto!  
Estoy abierto a feedback y sugerencias para seguir mejorando. 🚀

---

## Contacto

Puedes encontrar más proyectos y contactarme en mi perfil de GitHub: [DavidSvq](https://github.com/DavidSvq)
