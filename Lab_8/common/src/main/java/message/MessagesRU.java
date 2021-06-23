package message;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MessagesRU implements Messages{

    private final Map<String, String> translations;

    public MessagesRU() {
        translations = new HashMap<>();
        translations.put("title.error", "Ошибка");
        translations.put("title.command_executed", "Успешно");
        translations.put("input.id", "Введите ID:");
        translations.put("input.regex_name", "Введите название:");
        translations.put("menu_item.add", "Добавить");
        translations.put("title.filter", "Фильтр");
        translations.put("err.bad_regex", "Ошибка в формате строки");
        translations.put("input.coordinates_x", "Введите X:");
        translations.put("input.coordinates_y", "Введите Y:");
        translations.put("err.no_float", "Ошибка. Введенное число должно быть float.");
        translations.put("err.no_integer", "Ошибка. Введенное число должно быть integer.");
        translations.put("input.creation_date", "Введите дату создания:");
        translations.put("err.no_date", "Ошибка. Введенная строка не является датой.");
        translations.put("input.engine_power", "Введите мощность двигателя.");
        translations.put("input.num_of_wheels", "Введите количество колес.");
        translations.put("input.dist_travelled", "Введите пробег:");
        translations.put("input.fuel_type", "Введите тип топлива:");
        translations.put("input.username", "Введите имя пользователя:");
        translations.put("menu_item.update", "Обновление автомобиля");
        translations.put("err.pwd_not_match", "Ошибка. Пароли не совпадают.");
        translations.put("title.info", "Информация о коллекции:");
        translations.put("title.help", "Справка:");
        translations.put("title.head", "Первый элемент:");
        translations.put("title.field_asc", "Количество колес по возрастанию:");
        translations.put("title.update", "Обновление:");
        translations.put("err.invalid_name", "Некорректное название.");
        translations.put("err.invalid_coordinates_x", "Некорректный X.");
        translations.put("err.invalid_coordinates_y", "Некорректный Y.");
        translations.put("err.invalid_engine_power", "Некорректная мощность двигателя.");
        translations.put("err.invalid_dist", "Некорректный пробег.");
        translations.put("label.login", "Логин:");
        translations.put("label.password", "Пароль:");
        translations.put("button.login", "Войти");
        translations.put("button.cancel", "Отмена");
        translations.put("tab.login", "Вход");
        translations.put("button.register", "Регистрация");
        translations.put("button.exit", "Выйти");
        translations.put("label.repeat_password", "Повторите пароль:");
        translations.put("tab.register", "Регистрация");
        translations.put("button.ok", "Подтвердить");
        translations.put("label.name", "Название:");
        translations.put("label.engine_power", "Мощность:");
        translations.put("label.num_of_wheels", "Колес:");
        translations.put("label.dist", "Пробег:");
        translations.put("label.fuel_type", "Топливо:");
        translations.put("label.coordinates", "Местоположение:");
        translations.put("label.x", "X:");
        translations.put("label.y", "Y:");
        translations.put("label.id", "ID:");
        translations.put("label.username", "Владелец:");
        translations.put("label.creation_date", "Дата создания:");
        translations.put("menu.locale", "Язык");
        translations.put("menu.commands", "Команды");
        translations.put("menu.add", "Добавление");
        translations.put("menu.filter", "Фильтр");
        translations.put("menu_item.change_color", "Поменять цвет");
        translations.put("menu_item.change_user", "Поменять пользователя");
        translations.put("menu_item.russian", "Русский");
        translations.put("menu_item.bulgarian", "Болгарский");
        translations.put("menu_item.belarus", "Беларусский");
        translations.put("menu_item.costa_rica", "Испанский(Коста-Рика)");
        translations.put("menu_item.help", "Справка");
        translations.put("menu_item.info", "Информация");
        translations.put("menu_item.remove", "Удаление");
        translations.put("menu_item.clear", "Очистить");
        translations.put("menu_item.head", "Первый элемент");
        translations.put("menu_item.execute_script", "Выполнить скрипт");
        translations.put("menu_item.id_filter", "Фильтр по ID");
        translations.put("menu_item.name_filter", "Фильтр по названию");
        translations.put("menu_item.coordinates_x_filter", "Фильтр по X");
        translations.put("menu_item.coordinates_y_filter", "Фильтр по Y");
        translations.put("menu_item.creation_date_filter", "Фильтр по дате создания");
        translations.put("menu_item.engine_power_filter", "Фильтр по мощности");
        translations.put("menu_item.number_of_wheels_filter", "Фильтр по количеству колес");
        translations.put("menu_item.distance_travelled_filter", "Фильтр по пробегу");
        translations.put("menu_item.fuel_type_filter", "Фильтр по топливу");
        translations.put("menu_item.username_filter", "Фильтр по владельцу");
        translations.put("tab.table", "Таблица");
        translations.put("tab.visualize", "Визуализация");
        translations.put("column.id", "ID");
        translations.put("column.name", "Название");
        translations.put("column.coordinates_x", "X");
        translations.put("column.coordinates_y", "Y");
        translations.put("column.creation_date", "Дата создания");
        translations.put("column.engine_power", "Мощность");
        translations.put("column.number_of_wheels", "Количество колес");
        translations.put("column.fuel_type", "Топливо");
        translations.put("column.distance_travelled", "Пробег");
        translations.put("column.username", "Создатель");
        translations.put("menu_item.min_by_distance", "Минимальный по пробегу");
        translations.put("menu_item.remove_head", "Удалить первый и показать");
        translations.put("menu_item.remove_first", "Удалить первый");
        translations.put("menu_item.print_field", "Колеса по возрастанию");
        translations.put("title.update_vehicle", "Обновить автомобиль");
        translations.put("err.add", "Ошибка при добавлении элемента.");
        translations.put("err.arg", "Ошибка в аргументе команды.");
        translations.put("err.no_such", "Ошибка. В вашей части коллекции нет подходящего элемента.");
        translations.put("err.info", "Ошибка при получении информации о коллекции.");
        translations.put("err.login", "Ошибка при авторизации.");
        translations.put("vehicle.min_dist", "Автомобиль с минимальным пробегом: ");
        translations.put("desc.help", "вывести справку по доступным командам");
        translations.put("desc.info", " вывести информацию о коллекции");
        translations.put("desc.show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        translations.put("desc.add", "добавить новый элемент в коллекцию");
        translations.put("title.vehicle", "Автомобиль");
        translations.put("desc.update", "обновить значение элемента коллекции, id которого равен заданному");
        translations.put("desc.rem_id", "удалить элемент из коллекции по его id");
        translations.put("desc.clear", "очистить коллекцию");
        translations.put("desc.exec", "считать и исполнить скрипт из указанного файла.");
        translations.put("desc.rem_fir", "удалить первый элемент из коллекции");
        translations.put("desc.head", "вывести первый элемент коллекции");
        translations.put("desc.rem_head", "вывести первый элемент коллекции и удалить его");
        translations.put("desc.min", "вывести любой объект из коллекции, значение поля distanceTravelled которого является минимальным");
        translations.put("desc.pr_asc", "вывести элементы коллекции в порядке возрастания");
        translations.put("desc.pr_field", "вывести значения поля numberOfWheels всех элементов в порядке возрастания");
        translations.put("desc.login", "войти в систему");
        translations.put("desc.reg", "зарегистрироваться в системе");
        translations.put("suc.login", "Успешный вход.");
        translations.put("suc.reg", "Успешная регистрация");
        translations.put("err.reg", "Ошибка при регистрации: пользователь с данным ником уже существует");
        translations.put("err.login_empty", "Ошибка: логин и пароль не должны быть пустыми");
        translations.put("suc.rem", "Успешное удаление элемента");
        translations.put("err_rem", "Ошибка при удалении элемента");
        translations.put("suc.update", "Успешное обновление элемента");
        translations.put("err.unk_type", "Ошибка. Неизвестный тип вопроса");
        translations.put("err.build", "Ошибка при создании автомобиля");
        translations.put("err.connection", "Ошибка при связи с сервером. Сервер временно недоступен.");
        translations.put("err.unk", "Неизвестная ошибка");
        translations.put("err.script_rec", "Ошибка: скрипт содержит рекурсию");
        translations.put("err.script", "Ошибка во время исполнения скрипта");
        translations.put("err.file_read", "Ошибка: файл недоступен для чтения");
        translations.put("err.file", "Ошибка: файл недоступен");
        translations.put("suc.exec", "Успешное исполнение скрипта");
        translations.put("info.type", "Тип коллекции: ");
        translations.put("info.cnt", "Количество элементов: ");
        translations.put("info.cr_date", "Дата инициализации: ");
        translations.put("info.upd_date", "Дата обновления: ");
        translations.put("info.no_upd_date", "Дата обновления: не обновлялась");
        translations.put("err.invalid_num_of_wheels", "Ошибка. Некорректное количество колес.");
        translations.put("title.script", "Выполнение скрипта");
        translations.put("input.script", "Введите скриптовый файл:");
        translations.put("title.remove", "Удаление элемента");
    }

    @Override
    public String getString(String key) {
        return translations.getOrDefault(key, key);
    }

    @Override
    public String getDate(LocalDate date) {
        return null;
    }
}
