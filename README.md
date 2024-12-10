Proyecto: Gestión de Learning Paths
SE DEBE CORRER EL PROGRAMA DESDE LA CLASE INTERFAZ AUTENTICACIÓN

Este proyecto tiene como objetivo proporcionar una herramienta para gestionar Learning Paths y actividades asociadas. Incluye funcionalidades específicas para profesores y estudiantes, además de persistencia de datos para usuarios, Learning Paths, reseñas y actividades.

Funcionalidades principales
Interfaz de Profesor
Las interfaces para el profesor están completamente funcionales y permiten:

Gestión de Learning Paths:

Añadir nuevos Learning Paths.
Editar Learning Paths existentes.
Ver una lista de Learning Paths creados.
Gestión de Actividades:

Añadir actividades a cualquier Learning Path (nuevo o existente).
Ver las actividades asociadas a un Learning Path.
Persistencia
Usuarios:

El sistema guarda y gestiona usuarios, diferenciando entre profesores y estudiantes.
Usuarios disponibles para pruebas:
Profesor:
Usuario: santiago
Contraseña: 123
Estudiante:
Usuario: pablo
Contraseña: 123
Nota: Los nombres de usuario deben ingresarse exactamente como se indican (en minúsculas).
Learning Paths y Actividades:

La persistencia de datos se realiza en la carpeta data, donde se organizan los archivos y carpetas según si los datos corresponden a usuarios, Learning Paths o actividades específicas.
Al abrir la ventana del profesor, los nombres de los Learning Paths existentes se muestran en la consola.
Ejemplo:
El Learning Path llamado suma ya contiene actividades asociadas.
Se pueden añadir nuevas actividades a cualquier Learning Path existente o recién creado.
Interfaz de Estudiante
Aunque la interfaz de estudiante no se completó al 100%, la lógica y las clases necesarias están disponibles en los paquetes:

Consola
Usuario
Estos paquetes contienen métodos que implementan las funcionalidades planificadas para los estudiantes.

Estructura del Proyecto
Paquetes
VentanasProfesor: Contiene todo lo relacionado con la interfaz gráfica para los profesores.
VentanasEstudiante: Contiene todo lo relacionado con la interfaz gráfica para los estudiantes.
Consola: Incluye métodos y clases para las operaciones relacionadas con los estudiantes.
Usuario: Gestiona la lógica de los usuarios y sus operaciones.
Persistencia
La información persistente se guarda en la carpeta data. Esta incluye:

Datos de usuarios.
Learning Paths y actividades, organizados por tipo y asociación.
Archivos separados para cada entidad (usuarios, Learning Paths, actividades).
Recomendaciones para Pruebas
Acceso:

Profesor: Inicia sesión con el usuario santiago y contraseña 123.
Estudiante: Inicia sesión con el usuario pablo y contraseña 123.
Exploración de Funcionalidades:

Utiliza la interfaz del profesor para:
Añadir y editar Learning Paths.
Crear actividades y asociarlas a Learning Paths existentes.
Ver la lista de actividades para un Learning Path específico (como el Learning Path suma).
Revisar Persistencia:

Verifica los archivos y carpetas generados en la carpeta data para confirmar que los datos se están guardando correctamente.
Probar Estudiante:


Notas Finales
Este proyecto proporciona una base sólida para la gestión de Learning Paths y actividades, con una interfaz completamente funcional para profesores y persistencia confiable de los datos.
