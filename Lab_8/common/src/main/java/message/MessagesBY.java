package message;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MessagesBY implements Messages{

    private final Map<String, String> translations;

    public MessagesBY() {
        translations = new HashMap<>();
        translations.put("title.error", "Памылка");
        translations.put("title.command_executed", " Паспяхова");
        translations.put("input.id", " Калі ласка, увядзіце ID:");
        translations.put("input.regex_name", " Калі ласка, увядзіце назву:");
        translations.put("menu_item.add", " Дадаць");
        translations.put("title.filter", " Фільтр");
        translations.put("err.bad_regex", " Памылка ў фармаце радка");
        translations.put("input.coordinates_x", " Калі ласка, увядзіце X:");
        translations.put("input.coordinates_y", " Калі ласка, увядзіце Y:");
        translations.put("err.no_float", " Памылка. Уведзенае лік павінна быць float.");
        translations.put("err.no_integer", " Памылка. Уведзенае лік павінна быць integer.");
        translations.put("input.creation_date", " Увядзіце дату стварэння:");
        translations.put ("err.no_date", " Памылка. Уведзеная радок не з'яўляецца датай.");
        translations.put("input.engine_power", " Калі ласка, увядзіце магутнасць рухавіка.");
        translations.put("input.num_of_wheels", " Калі ласка, увядзіце колькасць колаў.");
        translations.put("input.dist_travelled", " Калі ласка, увядзіце прабег:");
        translations.put("input.fuel_type", " Калі ласка, увядзіце тып паліва:");
        translations.put("input.username", " Калі ласка, увядзіце імя карыстальніка:");
        translations.put("menu_item.update", " Абнаўленне аўтамабіля:");
        translations.put("err.pwd_not_match", " Памылка. Паролі не супадаюць.");
        translations.put("title.info", " Iнфармацыя аб калекцыі:");
        translations.put("title.help", " Даведка:");
        translations.put("title.head", " Першы элемент:");
        translations.put("title.field_asc", " Колькасць колаў па ўзрастанні:");
        translations.put("title.update", " Абнаўленне:");
        translations.put("err.invalid_name", " Некарэктная назва.");
        translations.put("err.invalid_coordinates_x", " Некарэктны X.");
        translations.put("err.invalid_coordinates_y", " Некарэктны y.");
        translations.put("err.invalid_engine_power", " Некарэктная магутнасць рухавіка.");
        translations.put("err.invalid_dist", " Некарэктны прабег.");
        translations.put("label.login", " Лагін:");
        translations.put("label.password", " Пароль:");
        translations.put("button.login", " Увайсці");
        translations.put("button.cancel", " Адмена");
        translations.put("tab.login", " Уваход");
        translations.put("button.register", " Рэгістрацыя");
        translations.put("button.exit", " Выйсці");
        translations.put("label.repeat_password", " Паўтарыце пароль:");
        translations.put("tab.register", " Рэгістрацыя");
        translations.put("button.ok", " Пацвердзіць");
        translations.put("label.name", " Назву:");
        translations.put("label.engine_power", " Магутнасць:");
        translations.put("label.num_of_wheels", " Колаў:");
        translations.put("label.dist", " Прабег:");
        translations.put("label.fuel_type", " Паліва:");
        translations.put("label.coordinates", " Месцазнаходжанне:");
        translations.put("label.x", "X:");
        translations.put("label.y", "Y:");
        translations.put("label.id", "ID:");
        translations.put("label.username", " Уладальнік:");
        translations.put("label.creation_date", " Дата стварэння:");
        translations.put("menu.locale", "Мова");
        translations.put("menu.commands", " Каманды");
        translations.put("menu.add", " Даданне");
        translations.put("menu.filter", " Фільтр");
        translations.put("menu_item.change_color", " Памяняць колер");
        translations.put("menu_item.change_user", " Памяняць карыстальніка");
        translations.put("menu_item.russian", " Русская");
        translations.put("menu_item.bulgarian", " Балгарская");
        translations.put("menu_item.belarus", " Беларускі");
        translations.put("menu_item.costa_rica", " Іспанская (Коста-Рыка)");
        translations.put("menu_item.help", " Даведка");
        translations.put("menu_item.info", " Iнфармацыя");
        translations.put("menu_item.remove", " Выдаленне");
        translations.put("menu_item.clear", " Ачысціць");
        translations.put("menu_item.head", " Першы элемент");
        translations.put("menu_item.execute_script", " Выканаць скрыпт");
        translations.put ("menu_item.id_filter", " Фільтр па ID");
        translations.put ("menu_item.name_filter", " Фільтр па назве");
        translations.put("menu_item.coordinates_x_filter", " Фільтр па X");
        translations.put("menu_item.coordinates_y_filter", " Фільтр па Y");
        translations.put("menu_item.creation_date_filter", " Фільтр па даце стварэння");
        translations.put("menu_item.engine_power_filter", " Фільтр па магутнасці");
        translations.put("menu_item.number_of_wheels_filter", " Фільтр па колькасці колаў");
        translations.put("menu_item.distance_travelled_filter", " Фільтр па прабегу");
        translations.put("menu_item.fuel_type_filter", " Фільтр па паліве");
        translations.put("menu_item.username_filter", " Фільтр па ўладальніку");
        translations.put("tab.table", " Табліца");
        translations.put("tab.visualize", " Візуалізацыя");
        translations.put("column.id", "ID");
        translations.put("column.name", " Назву");
        translations.put("column.coordinates_x", "X");
        translations.put("column.coordinates_y", "Y");
        translations.put("column.creation_date", " Дата стварэння");
        translations.put("column.engine_power", " Магутнасць");
        translations.put("column.number_of_wheels", " Колькасць колаў");
        translations.put("column.fuel_type", " Паліва");
        translations.put("column.distance_travelled", " Прабег");
        translations.put("column.username", " Стваральнік");
        translations.put("menu_item.min_by_distance", " Мінімальны па прабегу");
        translations.put("menu_item.remove_head", " Выдаліць Першы і паказаць");
        translations.put("menu_item.remove_first", " Выдаліць Першы");
        translations.put("menu_item.print_field", " Колы па ўзрастанні");
        translations.put("title.update_vehicle", " Абнавіць аўтамабіль");
        translations.put("err.add", " Памылка пры даданні элемента.");
        translations.put("err.arg", " Памылка ў аргуменце каманды.");
        translations.put ("err.no_such", " Памылка. У вашай часткі калекцыі няма падыходнага элемента.");
        translations.put("err.info", " Памылка пры атрыманні інфармацыі аб калекцыі.");
        translations.put("err.login", " Памылка пры аўтарызацыі.");
        translations.put("vehicle.min_dist", " Аўтамабіль з мінімальным прабегам: ");
        translations.put("desc.help", " Вывесці даведку па даступных камандам");
        translations.put("desc.info", " Вывесці інфармацыю аб калекцыі");
        translations.put("desc.show", " Вывесці ў стандартны паток вываду ўсе элементы калекцыі ў радковым прадстаўленні");
        translations.put("desc.add", " Дадаць новы элемент у калекцыю");
        translations.put("title.vehicle", " Аўтамабіль");
        translations.put("desc.update", " Абнавіць значэнне элемента калекцыі, id якога роўны зададзенаму");
        translations.put("desc.rem_id", " Выдаліць элемент з калекцыі па яго id");
        translations.put("desc.clear", " Ачысціць калекцыю");
        translations.put("desc.exec", " Лічыць і выканаць скрыпт з названага файла.");
        translations.put("desc.rem_fir", " Выдаліць першы элемент з калекцыі");
        translations.put("desc.head", " Вывесці першы элемент калекцыі");
        translations.put("desc.rem_head", " Вывесці першы элемент калекцыі і выдаліць яго");
        translations.put("desc.min", " Вывесці любы аб'ект з калекцыі, значэнне поля distanceTravelled якога з'яўляецца мінімальным");
        translations.put("desc.pr_asc", " Вывесці элементы калекцыі ў парадку ўзрастання");
        translations.put("desc.pr_field", " Вывесці значэння поля numberOfWheels ўсіх элементаў у парадку ўзрастання");
        translations.put("desc.login", " Увайсці ў сістэму");
        translations.put("desc.reg", " Зарэгістравацца ў сістэме");
        translations.put("suc.login", " Паспяховы ўваход.");
        translations.put("suc.reg", " Паспяховая рэгістрацыя");
        translations.put("err.reg", " Памылка пры рэгістрацыі");
        translations.put("err.login_empty", " Памылка: лагін і пароль не павінны быць пустымі");
        translations.put("suc.rem", " Паспяховае Выдаленне элемента");
        translations.put ("err_rem", " Памылка пры выдаленні элемента");
        translations.put("suc.update", " Паспяховае абнаўленне элемента");
        translations.put("err.unk_type", " Памылка. Невядомы тып пытання");
        translations.put("err.build", " Памылка пры стварэнні аўтамабіля");
        translations.put("err.connection", " Памылка пры сувязі з серверам. Сервер часова недаступны.");
        translations.put("err.unk", " Невядомая памылка");
        translations.put("err.script_rec", " Памылка: скрыпт змяшчае рэкурсію");
        translations.put("err.script", " Памылка падчас выканання скрыпту");
        translations.put("err.file_read", " Памылка: файл недаступны для чытання");
        translations.put("err.file", " Памылка: файл недаступны");
        translations.put("suc.exec", " Паспяховае выкананне скрыпту");
        translations.put("info.type", " Тып калекцыі: ");
        translations.put("info.cnt", " Колькасць элементаў: ");
        translations.put ("info.cr_date", " Дата ініцыялізацыі: ");
        translations.put("info.upd_date", " Дата абнаўлення: ");
        translations.put ("info.no_upd_date", " Дата абнаўлення: не абнаўлялася");
        translations.put("err.invalid_num_of_wheels", "Памылка. Некарэктная колькасць колаў.");
        translations.put("title.script", " Выкананне скрыпту");
        translations.put("input.script", "Калі ласка, Увядзіце файл скрыптовы:");
        translations.put("title.remove", " Выдаленне элемента");
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
