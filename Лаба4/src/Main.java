
public class Main {
    public static void main(String[] args) throws GoException {

        ThePeninsulaOfRossImplInfo thePeninsulaOfRossImplInfo = new ThePeninsulaOfRossImplInfo("полуостров Росса");
        Ship ship = new Ship();
        ship.setName("кораблям");
        Height height = new Height();
        height.setName(" выстот");
        Engaving engaving = new Engaving();
        engaving.setName(" гравюру ");
        Fudzi fudzi = new Fudzi("Фудзиямы");
        TerrorImplExtinct terrorImplExtinct = new TerrorImplExtinct(" вулкан Террор ");
        OutLine outLine = new OutLine();
        outLine.setName(" очертания ");
        We we = new We("мы");
        Ship.Anchor anchor = new Ship.Anchor();
        anchor.setName("якорь");
        Gigant gigant = new Gigant();
        gigant.setName(" гигант");
        Me me = new Me(" мне");
        MakMerdo makMerdo = new MakMerdo("залив Мак-Мердо");
        ErebusImplSmoked erebusImplSmoked = new ErebusImplSmoked("вулкана Эребус");
        KvebekkaImplSay kvebekkaImplSay = new KvebekkaImplSay("Квебекка");
        Move move = new Move();
        String atnoonName = Time.ATNOON.getName();
        Civilization civilization = new Civilization();
        civilization.setName(" цивилизации ");
        Sun sun = new Sun();
        sun.setName("солнце ");
        Day day = new Day();
        day.setName("день ");
        Iceberg iceberg = new Iceberg();
        iceberg.setName(" айсберги");
        Iceberg.Wall wall = new Iceberg.Wall();
        wall.setName(" стенами");
        SouthCircle southCircle = new SouthCircle();
        southCircle.setName(" Южный Полярный круг ");
        IceStop iceStop = new IceStop();
        iceStop.setName(" ледяные заторы ");
        Tropic tropic = new Tropic();
        tropic.setName(" тропиках ");
        Temperature temperature = new Temperature();
        temperature.setName(" температуры ");
        Temperature.Down tdown = new Temperature.Down();
        Challenge challenge = new Challenge();
        challenge.setName(" испытаний ");
        AtmosphericPhenomena atmosphericPhenomena = new AtmosphericPhenomena();
        atmosphericPhenomena.setName(" атмосферные явления ");
        AtmosphericPhenomena.Miraje miraje = new AtmosphericPhenomena.Miraje();
        Castle castle = new Castle();
        castle.setName(" замками ");
        Castle.Wall сwall = new Castle.Wall();
        сwall.setName(" стенами");
        Ice ice = new Ice();
        ice.setName(" льды ");
        Ice.Fault fault = new Ice.Fault();
        fault.setName(" расщелинами ");
        Mountain mountain = new Mountain();
        Mountain.WhiteLine whiteLine = new Mountain.WhiteLine();
        mountain.setName(" горная цепь ");
        Mainland mainland = new Mainland();
        mainland.setName(" материка ");
        Mainland.End end = new Mainland.End();
        DeathWorld deathWorld = new DeathWorld();
        deathWorld.setName(" мир ", " Смерти ");
        Guard guard = new Guard();
        guard.setName(" часовой ");
        AdmiralMaunt admiralMaunt = new AdmiralMaunt(" горы Адмиралтейства");
        Ader ader = new Ader(" мыс Адер ");
        Victoria victoria = new Victoria(" земли Виктории ");
        Victoria.Eastbeach eastbeach = new Victoria.Eastbeach();
        MakMerdo.Beach beach = new MakMerdo.Beach();
        ErebusImplSmoked.Ander ander = new ErebusImplSmoked.Ander();
        EndOfTheTrip endOfTheTrip = new EndOfTheTrip();
        endOfTheTrip.setName(" конец пути ");
        Landshaft ridges = new Landshaft("хребты", " величественные и таинственные ", " скрывали ", " материк ");
        Sun.Rays rays = new Sun.Rays("лучи солнца ", "невысоко поднимавшиеся над ", "бросали отблеск на ", " даже ");
        Horisonte horisonte = new Horisonte();
        horisonte.setName(" горизонтом ");
        Landshaft snow = new Landshaft(" снег", "белый ");
        Landshaft ices = new Landshaft(" льдинки ", " голубоватые");
        Landshaft crack = new Landshaft(" разводья", " между льдинами");
        Landshaft icepiks = new Landshaft(" выступы скал", " темные, гранитные");
        Landshaft piks = new Landshaft(" вершин ", " одниноких ", " среди ");
        Wind wind = new Wind(" арктический ветер", " свирепый", " буйствовал", " усмирял ", " вдали ");
        Wind.Gust gust = new Wind.Gust();
        Wind.Sound sound = wind.new Sound(" завывания ветра", " вызывали ", " разносились", " и вселяли ужас ");
        PictureOf pictureOf = new PictureOf(" представление ", " диковатых звуках ", "о");
        Paintings paintings = new Paintings(" все ", " напоминало", " пейзажи Николая Рериха ", "описания в Некрономиконе");
        Landshaft islandFranclin = new Landshaft(" остров Франклина");
        Landshaft mountPerry = new Landshaft(" гор Перри ", "на фоне ", " замаячили ");
        Landshaft iceBarier = new Landshaft("ледяной барьер", " огромный ", " протянулся ");
        Landshaft abstTHing = new Landshaft(" она ", ", как ", " обрывалась ");
        Dendorf dendorf = new Dendorf("студент Дендорф ", " обратил внимание", ", что на ", " также прибавил, что ");
        Landshaft snowWall = new Landshaft(" склоне ", " заснеженном", " темнеет ", " лава ");
        Po po = new Po(" По ", " вдохновился");
        Landshaft thisMount = new Landshaft(" этой горой", " открытой в ");


        Abst abst = new Abst() {
            @Override
            public void remove() {
                System.out.print(" Удаляясь от" + civilization.getName());

            }
        };

        abst.remove();
        sun.sunset(" садилось", (byte) 1);
        System.out.println(day.getUp());

        System.out.print(Location.South.getLocation(" около ", 62));
        System.out.print(we.getName() + we.action(" заметили"));
        iceberg.flat();
        wall.vertical();
        System.out.println(" потом " + we.action("стали натыкаться на") + iceStop.getName());
        System.out.print(we.action(" пройдя ") + day.getDate("20 октября") + southCircle.getName());
        System.out.println(we.getName() + we.action(" отпраздновали "));
        me.after(tropic);
        System.out.print(tdown.getDown(temperature));
        System.out.println(tdown.torment(me) + ", но " + me.inHang + me.action(" в ожидании"));
        challenge.harsh();
        atmosphericPhenomena.wow(me);
        miraje.wow2(me);
        System.out.println(iceberg.seem() + castle.fantastic() + сwall.sharp());
        System.out.println(we.action(" пробившись сквозь ") + ice.fault(fault) + we.getName() + we.action(" вышли ") + Location.South.getLocation("в районе ", 67) + Location.West.getLocation("и ", 175));
        System.out.println(Time.MORNING.getName() + day.getDate(" 26 октября "));
        whiteLine.appear();
        System.out.println(Time.NOON.getName() + we.ourselves + we.action(" охватил восторг "));
        System.out.println("впереди" + mountain.lay(" простиралась ") + mountain.getDiscription());
        mainland.on(end, mountain);
        guard.onPost();
        guard.guarding();
        deathWorld.getDescription();
        System.out.println(admiralMaunt.info(" несомненно это были ") + admiralMaunt.byRoss());
        System.out.println(we.us + we.action("предстаяло обогнув") + ader.getName() + we.action(" плыть вдоль "));
        victoria.get(eastbeach);
        System.out.println(beach.getName() + ander.getName() + Location.South.getLocation(" на ", 78));
        System.out.println(endOfTheTrip.wow(" впечатлял "));
        System.out.println(ridges.getDescription() + ridges.getName() + ridges.getAction() + ridges.getHow());
        System.out.println(rays.getName() + rays.getDescription() + horisonte.getName() + rays.getHow() + Time.ATNOON.getName());
        System.out.println(rays.getAction() + snow.getDescription() + snow.getName() + "," + ices.getDescription() + ices.getName() + ",");
        System.out.println(crack.getName() + crack.getDescription() + "," + icepiks.getDescription() + icepiks.getName());
        System.out.println(wind.getHow() + piks.getAction() + piks.getDescription() + piks.getAction() + piks.getName());
        System.out.println(wind.getAction() + wind.getDescription() + wind.getName());
        System.out.println(wind.getName() + wind.notLong + wind.getAction2() + gust.getName());
        System.out.println(sound.getName() + sound.getAction() + pictureOf.getName() + pictureOf.getAbout() + pictureOf.getDescription());
        System.out.println(sound.getName() + sound.getAction2() + sound.getAction3());
        System.out.println(paintings.getName() + paintings.getAction() + paintings.getDescription() + " и " + paintings.getDescription2());
        me.takePity(paintings, " пожалел о том, ", "что читал ");
        System.out.println(day.getDate("7 ноября ") + mountain.getName() + mountain.disappear(" из нашего поля зрения "));
        System.out.println(we.getName() + we.action(" миновали ") + islandFranclin.getName() + mountPerry.getDescription() + mountPerry.getName() + mountPerry.getAction());
        thePeninsulaOfRossImplInfo.setName(" полуострове Росса");
        erebusImplSmoked.setName(" вулкан Эребус");
        System.out.println(erebusImplSmoked.getName() + " и" + terrorImplExtinct.getName() + " на " + thePeninsulaOfRossImplInfo.getName());
        thePeninsulaOfRossImplInfo.setName(" полуостров Росса");
        whiteLine.setName(" белесой полоской ");
        System.out.println(Location.West1.getName() + whiteLine.getName() + iceBarier.getAction() + iceBarier.getDescription() + iceBarier.getName() + height.getName() + "ой" + Fut.HAIGHT3.getName());
        System.out.println(abstTHing.getName() + abstTHing.getAction() + abstTHing.getDescription() + icepiks.getName());


        erebusImplSmoked.setName(" вулкана Эребус");
        System.out.println(thePeninsulaOfRossImplInfo.info("Здесь имеется ввиду "));
        move.movement1();
        move.choice1();
        move.aVoid();
        try {
            move.vvod(kvebekkaImplSay, 1);
            System.out.print(kvebekkaImplSay.getName());
            kvebekkaImplSay.speech(" ясно говорил");
            ship.canGo(" идти нельзя ");
        } catch (GoException goExeption) {
            System.out.println(goExeption.getMessage());
        } finally {
            System.out.println(atnoonName + makMerdo.setLocation(we, " вошли в "));
        }

        we.stayOn(anchor, "встали на ");
        System.out.println(erebusImplSmoked.smokeing(" курящегося "));

        outLine.lined(true, gigant);
        height.provade();
        me.remembered(engaving, fudzi, " напомнили ");
        System.out.print(gigant.behind());

        TerrorImplExtinct.whiteing sth = () -> {
            TerrorImplExtinct.ghostly();
            return " белел ";
        };

        System.out.print(sth.reverse());

        terrorImplExtinct.extincting("потухающий");
        System.out.println(height.equal(terrorImplExtinct));


        System.out.println(erebusImplSmoked.getSmoke(" дым ", " выпускал"));
        System.out.println(dendorf.getName() + dendorf.getNotise() + dendorf.getOn() + snowWall.getDescription() + snowWall.getName() + snowWall.getAction() + snowWall.getHow());
        System.out.println(dendorf.getName() + dendorf.getAdd() + po.getName() + po.getAction());
        System.out.println(thisMount.getName() + thisMount.getDescription() + day.getDate(" 1840 году "));
        System.out.println(" и " + po.action(" написал ") + po.speech("\" Было сердце мое горячее\""));


        TheEndException theEndExeptionYes = new TheEndException("Это конец рассказа");
        TheEndException theEndExeptionNo = new TheEndException("Это все равно конец рассказа");
        move.movement2();
        move.choice2();
        move.a2Void();
        TheEnd theEnd = new TheEnd() {
            @Override
            public void ending(Move move) {
                if (move.a2 == 1) {
                    //throw new TheEndException(theEndExeptionYes.getMessage());
                    System.out.println("Это конец рассказа");
                }  else throw new TheEndException(theEndExeptionNo.getMessage());
            }
        };
        theEnd.ending(move);
    }
}

