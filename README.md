
# Documentación del Proyecto: Trivia

## 1. Introducción
Este proyecto implementa un juego de trivia con múltiples categorías y niveles de dificultad. Los usuarios pueden iniciar sesión, jugar preguntas y ver sus resultados. Los administradores pueden gestionar preguntas y usuarios. Está desarrollado en Java, MySQL y una GUI estética en Swing.

---

## 2. Estructura General del Proyecto

### Paquetes:
- `Logica`: contiene las entidades del dominio (Usuario, Pregunta, etc.)
- `BBDD`: gestiona la conexión a la base de datos y acceso a datos (UsuarioBBDD, PreguntaBBDD, etc.)
- `Interfaz`: contiene las interfaces gráficas (Login, Juego, MenuAdmin, etc.)
- `Estilo`: aplica personalización visual a los componentes

---

## 3. Clases y Métodos Explicados

### Clase: `Usuario`
**Propósito:** Representa a un usuario del sistema.

- `int id`
- `String nombre`
- `String contrasena`
- `String tipo`

---

### Clase: `Pregunta`
**Propósito:** Representa una pregunta del juego.

- `int id`
- `String enunciado`
- `String categoria`
- `String dificultad`

---

### Clase: `Respuesta`
**Propósito:** Opción de respuesta para una pregunta.

- `int id`
- `int idPregunta`
- `String texto`
- `boolean esCorrecta`

---

### Clase: `Partida`
**Propósito:** Representa una sesión de juego y almacena puntaje.

- `int id`
- `int idUsuario`
- `LocalDate fecha`
- `int puntaje`

---

### Clase: `UsuarioBBDD`
**Propósito:** Acceso a datos para usuarios.

- `Usuario obtenerUsuario(String nombre, String contrasena)`
    - Verifica credenciales.
- `List<Usuario> obtener Todos()`
    - Devuelve una lista completa de usuarios.
- `boolean registrarUsuario(Usuario usuario)`
    - Registra un nuevo usuario en la Base de Datos.
- `boolean existeUsuario(String nombre)`
    - Verifica si el nombre esta o no en uso.
- `boolean eliminarUsuario(int id)`
    - Elimina un usuario por ID.

---

### Clase: `PreguntaBBDD`
**Propósito:** Acceso a datos para preguntas.

- `List<Pregunta> obtenerPreguntasPorCategoriaYDificultad(String categoria, String dificultad)`
    - Devuelve preguntas filtradas.
- `boolean insertarPregunta(Pregunta pregunta)`
    - Inserta nueva pregunta.
- `boolean eliminarPregunta(int id)`
    - Elimina pregunta por ID.

---

### Clase: `Conexion`
**Propósito:** Establecer conexión con la base de datos.

- `static Connection getConexion()`
    - Devuelve una conexión activa.
- `static void cerraConexion()`
    - Cierra la conexión con la base de datos.

---

### Clase: `Login`
**Propósito:** Ventana de inicio de sesión (o registro).

- `Login()`
    - Constructor que inicializa los componentes y valida usuario.
- Eventos de botón:
    - Login, validación, abrir `Juego` o `MenuAdmin`.

---

### Clase: `Juego`
**Propósito:** Lógica principal del juego.

- Muestra preguntas y respuestas
- Verifica si la respuesta es correcta
- Acumula puntaje (10 ptos por pregunta acertada)
- Registra la partida en la base de datos

---

### Clase: `MenuAdmin`
**Propósito:** Interfaz para administrador.

- Botones para:
    - Agregar pregunta
    - Modificar pregunta
    - Eliminar pregunta
    - Eliminar usuario
    - Cerrar sesion (actual)

---

### Clase: `Estilo`
**Propósito:** Aplica estilo visual (colores, bordes, fuentes)

- Métodos estáticos para estilizar:
    - `aplicarTema(Jframe ventana)`
    - `crearBoton(String texto, Color colorFondo)`
    - `crearTitulo(String texto)`

---

## 4. Diagrama de Clases
📎 Archivo: `diagrama_clases_java.md` (archivo por separado)

## 5. Modelo Entidad-Relación
📎 Archivo: `modelo_entidad-relacion_bbdd.md` (archivo por separado)
