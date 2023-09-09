**La clase TextPrompt se utiliza para mostrar un texto de sugerencia o indicación sobre un componente de texto (por ejemplo, un campo de texto) cuando el documento asociado a ese componente está vacío. Esta clase es especialmente útil en interfaces gráficas de usuario para proporcionar información adicional o ejemplos de entrada a los usuarios cuando están interactuando con campos de texto.**

### La clase tiene las siguientes características y funcionalidades:

> Puede mostrar un mensaje de texto (prompt) sobre el componente de texto cuando el Document asociado está vacío.
> El prompt se puede mostrar siempre, cuando el componente gana el foco o cuando lo pierde, según la configuración proporcionada.
> Permite establecer la fuente y el color del texto del prompt.
> Puede controlar si el prompt se muestra solo una vez o repetidamente.
> Cambia la visibilidad del prompt según las acciones del usuario, como ganar o perder el foco o realizar cambios en el documento.

`Ejemplo de uso`

-         TextPrompt codigo = new TextPrompt("Ingrese su codigo", jtCodigo);
-         TextPrompt nombre = new TextPrompt("Ingrese su nombre", jtNombres);
-         TextPrompt sueldo = new TextPrompt("Ingrese su sueldo", jtSueldo);
