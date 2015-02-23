# barx
**barx** (**B**ancos **Ar**gentinos e**x**porter) es un exportador de información del estado de cuenta de Banco Galicia a CSV/QIF para usar en MoneyManagerEx, GnuCash, etc.

# Objetivo y motivación
**barx** es un parser para la información que da el Banco Galicia en su servicio de Home Banking.
La intención es escribir un código que pueda ser capaz de: 
- conectarse a la página del banco
- parsear el documento (ya sea leyendo el código HTML o bien tomando la opción *exportar a XLS*
- exportar en formatos QIF y CSV compatibles con MoneyManagerEx y otros. 

Soy cliente del Banco Galicia y no encontré forma de *sacar* los datos (que son mios) en un formato accesible para cualquier programa de gestión de finanzas. 
Por eso decidí iniciar este pequeño programa con el cual satisfacer mi necesidad. 

# Uso 
TBD

# Disclaimer
Bajo ningún punto estoy afiliado o tengo intereses con el Banco Galica. Este programa se distribuye bajo licencia GNU. 
Siéntase libre de modificarlo a gusto siempre que cite este desarrollo como original. 

# Dependencias y librerias
Este programa usa: 
- **jsoup** (http://jsoup.org) para el parseo
- **jfreechart** (http://jfree.org) para los graficos
