package message;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MessagesCR implements Messages{

    private final Map<String, String> translations;

    public MessagesCR() {
        translations = new HashMap<>();
        translations.put("title.error", " Error");
        translations.put("title.command_executed", " Con Éxito");
        translations.put("input.id", " Introduzca el ID:");
        translations.put("input.regex_name", "Introduzca el nombre:");
        translations.put("menu_item.add", " Añadir");
        translations.put("title.filter", " Filtro");
        translations.put("err.bad_regex", " Error de formato de cadena");
        translations.put("input.coordinates_x", " Introduzca X:");
        translations.put("input.coordinates_y", " Escriba Y:");
        translations.put ("err.no_float", " Error. El número introducido debe ser float.");
        translations.put ("err.no_integer", " Error. El número introducido debe ser integer.");
        translations.put("input.creation_date", " Introduzca la fecha de creación:");
        translations.put ("err.no_date", " Error. La cadena introducida no es una fecha.");
        translations.put("input.engine_power", " Introduzca la potencia del motor.");
        translations.put("input.num_of_wheels", " Introduzca el número de ruedas.");
        translations.put("input.dist_travelled", " Introduzca el kilometraje:");
        translations.put("input.fuel_type", " Introduzca el tipo de combustible:");
        translations.put("input.username", " Introduzca el nombre de usuario:");
        translations.put("menu_item.update", " Actualización del coche:");
        translations.put("err.pwd_not_match", "Error. Las contraseñas no coinciden.");
        translations.put("title.info", " Información de la colección:");
        translations.put("title.help", " Ayuda:");
        translations.put("title.head", " Primer elemento:");
        translations.put("title.field_asc", " Número de ruedas ascendente:");
        translations.put("title.update", " Actualización:");
        translations.put("err.invalid_name", "Nombre Incorrecto.");
        translations.put("err.invalid_coordinates_x", "Incorrecto X.");
        translations.put("err.invalid_coordinates_y", "Incorrecto Y.");
        translations.put("err.invalid_engine_power", " Potencia del motor Incorrecta.");
        translations.put("err.invalid_dist", "Kilometraje Incorrecto.");
        translations.put("label.login", " Login:");
        translations.put("label.password", " Contraseña:");
        translations.put("button.login", " Iniciar Sesión");
        translations.put("button.cancel", " Cancelar");
        translations.put("tab.login", " Iniciar Sesión");
        translations.put("button.register", " Registro");
        translations.put("button.exit", " Salir");
        translations.put("label.repeat_password", " Repetir contraseña:");
        translations.put("tab.register", " Registro");
        translations.put("button.ok", " Confirmar");
        translations.put("label.name", " Título:");
        translations.put("label.engine_power", "Potencia:");
        translations.put("label.num_of_wheels", " Ruedas:");
        translations.put("label.dist", " Kilometraje:");
        translations.put("label.fuel_type", "Combustible:");
        translations.put("label.coordinates", " Ubicación:");
        translations.put("label.x", "X:");
        translations.put("label.y", "Y:");
        translations.put("label.id", "ID:");
        translations.put("label.username", " Propietario:");
        translations.put("label.creation_date", " Fecha de creación:");
        translations.put("menu.locale", " Idioma");
        translations.put("menu.commands", " Comandos");
        translations.put("menu.add", " Adición");
        translations.put("menu.filter", " Filtro");
        translations.put("menu_item.change_color", " Cambiar color");
        translations.put("menu_item.change_user", " Cambiar usuario");
        translations.put("menu_item.russian", " Ruso");
        translations.put("menu_item.bulgarian", " Búlgaro");
        translations.put("menu_item.belarus", " Bielorruso");
        translations.put("menu_item.costa_rica", " Español (costa rica)");
        translations.put("menu_item.help", " ayuda");
        translations.put("menu_item.info", " Información");
        translations.put("menu_item.remove", " Eliminar");
        translations.put("menu_item.clear", " Clear");
        translations.put("menu_item.head", " Primer elemento");
        translations.put("menu_item.execute_script", " Ejecutar script");
        translations.put ("menu_item.id_filter", " Filtrar por ID");
        translations.put ("menu_item.name_filter", " Filtrar por nombre");
        translations.put("menu_item.coordinates_x_filter", " Filtrar por X");
        translations.put("menu_item.coordinates_y_filter", " Filtrar por Y");
        translations.put("menu_item.creation_date_filter", " Filtrar por fecha de creación");
        translations.put("menu_item.engine_power_filter", " Filtro por potencia");
        translations.put("menu_item.number_of_wheels_filter", " Filtro por número de ruedas");
        translations.put("menu_item.distance_travelled_filter", " Filtro por kilometraje");
        translations.put("menu_item.fuel_type_filter", "Filtro de combustible");
        translations.put("menu_item.username_filter", " Filtro por propietario");
        translations.put("tab.table", " Tabla");
        translations.put("tab.visualize", " Visualización");
        translations.put("column.id", "ID");
        translations.put("column.name", " Título");
        translations.put("column.coordinates_x", "X");
        translations.put("column.coordinates_y", "Y");
        translations.put("column.creation_date", " Fecha de creación");
        translations.put("column.engine_power", "Potencia");
        translations.put("column.number_of_wheels", " número de ruedas");
        translations.put("column.fuel_type", "Combustible");
        translations.put("column.distance_travelled", " Kilometraje");
        translations.put("column.username", " Creador");
        translations.put("menu_item.min_by_distance", " Mínimo por kilometraje");
        translations.put("menu_item.remove_head", " Eliminar primero y Mostrar");
        translations.put("menu_item.remove_first", " Eliminar primero");
        translations.put("menu_item.print_field", " Ruedas ascendentes");
        translations.put("title.update_vehicle", " Actualizar coche");
        translations.put("err.add", "Error Al agregar un elemento.");
        translations.put("err.arg", " Error En el argumento del comando.");
        translations.put ("err.no_such", " Error. No hay un elemento adecuado en su parte de la colección.");
        translations.put("err.info", " Error al obtener información sobre la colección.");
        translations.put("err.login", " Error de autorización.");
        translations.put("vehicle.min_dist", " Vehículo con kilometraje mínimo: ");
        translations.put("desc.help", " Mostrar ayuda sobre los comandos disponibles");
        translations.put("desc.info", " Mostrar información de la colección");
        translations.put("desc.show", " Mostrar en el flujo de salida estándar todos los elementos de la colección en la vista de cadena");
        translations.put("desc.add", " Añadir un nuevo elemento a la colección");
        translations.put("title.vehicle", " Vehículo");
        translations.put("desc.update", " Actualizar el valor de un elemento de colección cuyo id es igual al especificado");
        translations.put("desc.rem_id", " Eliminar un elemento de la colección por su id");
        translations.put("desc.clear", " Borrar colección");
        translations.put("desc.exec", " Leer y ejecutar el script desde el archivo especificado.");
        translations.put("desc.rem_fir", " Eliminar el primer elemento de la colección");
        translations.put("desc.head", " Mostrar el primer elemento de la colección");
        translations.put("desc.rem_head", " Mostrar el primer elemento de la colección y eliminarlo");
        translations.put("desc.min", " Muestra cualquier objeto de la colección cuyo valor de campo distanceTravelled sea mínimo");
        translations.put ("desc.pr_asc", " Mostrar los elementos de la colección en orden ascendente");
        translations.put ("desc.pr_field", " Mostrar los valores del campo numberOfWheels de todos los elementos en orden ascendente");
        translations.put("desc.login", " Iniciar sesión");
        translations.put("desc.reg", " Registrarse en el sistema");
        translations.put("suc.login", " Inicio de sesión Exitoso.");
        translations.put("suc.reg", " Registro Exitoso");
        translations.put("err.reg", " Error de registro");
        translations.put("err.login_empty", " Error: el Inicio de sesión y la contraseña no deben estar vacíos");
        translations.put("suc.REM", " Eliminación Exitosa del elemento");
        translations.put ("err_rem", " Error al eliminar un elemento");
        translations.put("suc.update", " Actualización exitosa del elemento");
        translations.put("err.unk_type", "Error. Tipo de pregunta desconocido");
        translations.put("err.build", " Error al construir un automóvil");
        translations.put("err.connection", " Error al comunicarse con el servidor. El servidor no está disponible temporalmente.");
        translations.put("err.unk", " Error Desconocido");
        translations.put("err.script_rec", " Error: el script contiene recursión");
        translations.put("err.script", " Error Durante la ejecución del script");
        translations.put("err.file_read", "Error: el archivo no se puede Leer");
        translations.put("err.file", " Error: archivo no disponible");
        translations.put("suc.exec", " Ejecución exitosa del script");
        translations.put("info.type", " Tipo de colección: ");
        translations.put("info.cnt", " Número de elementos: ");
        translations.put ("info.cr_date", " Fecha de inicialización: ");
        translations.put("info.upd_date", " Fecha de actualización: ");
        translations.put ("info.no_upd_date", " Fecha de actualización: no actualizada");
        translations.put("err.invalid_num_of_wheels", "Error. Número incorrecto de ruedas");
        translations.put("title.script", " Ejecutar script");
        translations.put("input.script", " Escriba el archivo de script:");
        translations.put("title.remove", " Eliminar elemento");
    }

    @Override
    public String getString(String key) {
        return translations.get(key);
    }

    @Override
    public String getDate(LocalDate date) {
        return null;
    }
}
