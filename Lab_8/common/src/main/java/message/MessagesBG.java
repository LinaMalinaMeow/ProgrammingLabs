package message;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MessagesBG implements Messages{

    private final Map<String, String> translations;

    public MessagesBG() {
        translations = new HashMap<>();
        translations.put("title.error", " Грешка");
        translations.put("title.command_executed", " Успешно");
        translations.put("input.id", " Въведете ID:");
        translations.put("input.regex_name", " Въведете име:");
        translations.put("menu_item.add", " Добави");
        translations.put("title.filter", " Филтър");
        translations.put("err.bad_regex", " Грешка във формат на ред");
        translations.put("input.coordinates_x", " Въведете X:");
        translations.put("input.coordinates_y", " Въведете Y:");
        translations.put("err.no_float", " Грешка. Въведеното число трябва да бъде float.");
        translations.put("err.no_integer", " Грешка. Въведеното число трябва да бъде integer.");
        translations.put("input.creation_date", " Въведете датата на създаване:");
        translations.put("err.no_date", " грешка. Въведеният низ не е дата.");
        translations.put("input.engine_power", " Въведете мощността на двигателя.");
        translations.put("input.num_of_wheels", " Въведете броя на колелата.");
        translations.put("input.dist_travelled", " Въведете пробег:");
        translations.put("input.fuel_type", " Въведете типа гориво:");
        translations.put("input.username", " Въведете потребителско име:");
        translations.put("menu_item.update", " Обновяване на автомобила:");
        translations.put("err.pwd_not_match", " Грешка. Паролите не съвпадат.");
        translations.put("title.info", " Информация за колекцията:");
        translations.put("title.help", " Помощ:");
        translations.put("title.head", " Първият елемент:");
        translations.put("title.field_asc", " Брой колела възходящи:");
        translations.put("title.update", " Update:");
        translations.put("err.invalid_name", " Неправилно Заглавие.");
        translations.put("err.invalid_coordinates_x", " Невалиден X.");
        translations.put("err.invalid_coordinates_y", " Неправилно Y.");
        translations.put("err.invalid_engine_power", " Неправилна мощност на двигателя.");
        translations.put("err.invalid_dist", " Неправилен пробег.");
        translations.put("label.login", " Вход:");
        translations.put("label.password", " Парола:");
        translations.put("button.login", " Вход");
        translations.put("button.cancel", " Отказ");
        translations.put("tab.login", " Вход");
        translations.put("button.register", " Регистрация");
        translations.put("button.exit", " Изход");
        translations.put("label.repeat_password", " Повторете паролата:");
        translations.put("tab.register", " Регистрация");
        translations.put("button.ok", " Потвърди");
        translations.put("label.name", " Заглавие:");
        translations.put("label.engine_power", " Мощност:");
        translations.put("label.num_of_wheels", " Колела:");
        translations.put("label.dist", " Пробег:");
        translations.put("label.fuel_type", " Гориво:");
        translations.put("label.coordinates", " Местоположение:");
        translations.put("label.x", "X:");
        translations.put("label.y", "Y:");
        translations.put("label.id", "ID:");
        translations.put("label.username", " Собственик:");
        translations.put("label.creation_date", " Дата на създаване:");
        translations.put("menu.locale", " Език");
        translations.put("menu.commands", " Команди");
        translations.put("menu.add", " Добавяне");
        translations.put("menu.filter", " Филтър");
        translations.put("menu_item.change_color", " Промяна на цвета");
        translations.put("menu_item.change_user", " Промяна на потребител");
        translations.put("menu_item.russian", " Руски");
        translations.put("menu_item.bulgarian", " Български");
        translations.put("menu_item.belarus", " Беларуски");
        translations.put("menu_item.costa_rica", " Испански (Коста Рика)");
        translations.put("menu_item.help", " Помощ");
        translations.put("menu_item.info", " Информация");
        translations.put("menu_item.remove", " Изтриване");
        translations.put("menu_item.clear", " Clear");
        translations.put("menu_item.head", " Първият елемент");
        translations.put("menu_item.execute_script", " Изпълнение на скрипт");
        translations.put("menu_item.id_filter", " Филтър по ID");
        translations.put("menu_item.name_filter", "Филтър по име");
        translations.put("menu_item.coordinates_x_filter", " Филтър по X");
        translations.put("menu_item.coordinates_y_filter", " филтър от Y");
        translations.put("menu_item.creation_date_filter", " Филтър по Дата на създаване");
        translations.put("menu_item.engine_power_filter", " Филтър по мощност");
        translations.put("menu_item.number_of_wheels_filter", " Филтър по брой колела");
        translations.put("menu_item.distance_travelled_filter", " Филтър по пробег");
        translations.put("menu_item.fuel_type_filter", " Филтър за гориво");
        translations.put("menu_item.username_filter", " Филтър по собственик");
        translations.put("tab.table", " Таблица");
        translations.put("tab.visualize", " Визуализация");
        translations.put("column.id", "ID");
        translations.put("column.name", " Заглавие");
        translations.put("column.coordinates_x", "X");
        translations.put("column.coordinates_y", "Y");
        translations.put("column.creation_date", " Дата на създаване");
        translations.put("column.engine_power", " Мощност");
        translations.put("column.number_of_wheels", " Брой колела");
        translations.put("column.fuel_type", " Гориво");
        translations.put("column.distance_travelled", " Пробег");
        translations.put("column.username", " Създател");
        translations.put("menu_item.min_by_distance", " Минимален пробег");
        translations.put("menu_item.remove_head", " Изтриване на първия и покажи");
        translations.put("menu_item.remove_first", " Изтриване първо");
        translations.put("menu_item.print_field", " Възходящи колела");
        translations.put("title.update_vehicle", " Обновяване на колата");
        translations.put("err.add", " Грешка при добавяне на елемент.");
        translations.put("err.arg", " Грешка в аргумента на командата.");
        translations.put("err.no_such", " Грешка. Вашата част от колекцията няма подходящ елемент.");
        translations.put("err.info", " Грешка при получаване на информация за колекцията.");
        translations.put("err.login", " Грешка при оторизация.");
        translations.put("vehicle.min_dist", " Кола с минимален пробег: ");
        translations.put("desc.help", " Показване на помощ за наличните команди");
        translations.put("desc.info", " Показване на информация за колекцията");
        translations.put("desc.show", " Изведете в стандартен изходен поток всички елементи на колекцията в низов изглед");
        translations.put("desc.add", " Добавяне на нов елемент към колекцията");
        translations.put("title.vehicle", " Кола");
        translations.put("desc.update", " Актуализиране на стойността на елемента на колекцията, чийто id е равен на зададения");
        translations.put("desc.rem_id", " Премахване на елемент от колекцията от неговия id");
        translations.put("desc.clear", " Clear колекция");
        translations.put("desc.exec", " Брой и изпълни скрипт от посочения файл.");
        translations.put("desc.rem_fir", " Премахване на първия елемент от колекцията");
        translations.put("desc.head", " Изведете първия елемент от колекцията");
        translations.put("desc.rem_head", " Изведете първия елемент от колекцията и го изтрийте");
        translations.put("desc.min", " Изведете всеки обект от колекцията, чиято стойност на полето distanceTravelled е минимална");
        translations.put("desc.pr_asc", " Показване на елементите на колекцията във възходящ ред");
        translations.put("desc.pr_field", " Показване на стойностите на полето numberOfWheels на всички елементи във възходящ ред");
        translations.put("desc.login", " Вход");
        translations.put("desc.reg", " Регистрирайте се в системата");
        translations.put("suc.login", " Успешен вход.");
        translations.put("suc.reg", " Успешна регистрация");
        translations.put("err.reg", " Грешка при регистрация");
        translations.put("err.login_empty", " Грешка: потребителско име и парола не трябва да са празни");
        translations.put("suc.rem", " Успешно премахване на елемент");
        translations.put ("err_rem", " Грешка при изтриване на елемент");
        translations.put("suc.update", " Успешна актуализация елемент");
        translations.put("err.unk_type", " Грешка. Неизвестен тип въпрос");
        translations.put("err.build", " Грешка при създаване на кола");
        translations.put("err.connection", " Грешка при комуникация със сървъра. Сървърът е временно недостъпен.");
        translations.put("err.unk", " Неизвестна грешка");
        translations.put("err.script_rec", " Грешка: скриптът съдържа рекурсия");
        translations.put("err.script", " Грешка по време на изпълнение на скрипта");
        translations.put("err.file_read", " Грешка: Файлът не може да бъде прочетен");
        translations.put("err.file", " Грешка: Файлът не е наличен");
        translations.put("suc.exec", " Успешно изпълнение на скрипта");
        translations.put("info.type", " Тип колекция: ");
        translations.put("info.cnt", " Брой елементи: ");
        translations.put("info.cr_date", " Дата на инициализация: ");
        translations.put("info.upd_date", " Дата на обновяване: ");
        translations.put("info.no_upd_date", " Дата на обновяване: не е актуализирана");
        translations.put("err.invalid_num_of_wheels", "Грешка. Грешен брой колела.");
        translations.put("title.script", " изпълнение на скрипт");
        translations.put("input.script", " въведете скриптов файл:");
        translations.put("title.remove", " изтриване на елемент");
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
