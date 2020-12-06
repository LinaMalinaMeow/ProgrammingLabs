
public class Main {
    public static void main(String []args){

        ThePeninsulaOfRossImplInfo thePeninsulaOfRossImplInfo = new ThePeninsulaOfRossImplInfo("полуостров Росса");
        Ship ship =new Ship();
        ship.setName("кораблям");
        Height height=new Height();
        height.setName(" высот");
        Engaving engaving = new Engaving();
        engaving.setName(" гравюру ");
        Fudzi fudzi = new Fudzi("Фудзиямы");
        TerrorImplExtinct terrorImplExtinct = new TerrorImplExtinct(" вулкана Террор ");
        OutLine outLine=new OutLine();
        outLine.setName(" очертания ");
        We we=new We("мы");
        Anchor anchor = new Anchor();
        anchor.setName("якорь");
        Gigant gigant =new Gigant();
        gigant.setName(" этого гиганта");
        Me me = new Me(" мне");
        MakMerdo makMerdo = new MakMerdo("залив Мак-Мердо");
        ErebusImplSmoked erebusImplSmoked = new ErebusImplSmoked("вулкана Эребус");
        KvebekkaImplSay kvebekkaImplSay = new KvebekkaImplSay("Квебекка");
        Move move= new Move();
        String atnoonName = Time.ATNOON.getName();

        System.out.println(thePeninsulaOfRossImplInfo.info("Здесь и далее имеется ввиду "));
        move.movement1();
        move.choice1();
        move.vvod();
        if (move.may==true){
            System.out.print(kvebekkaImplSay.getName());
            kvebekkaImplSay.speech(" неясно говорил");
            ship.canGo(" идти дальше можно ");

        }else {
            System.out.print(kvebekkaImplSay.getName());
            kvebekkaImplSay.speech(" ясно говорил");
            ship.canGo(" идти дальше нельзя ");
        }
        System.out.println(atnoonName+makMerdo.setLocation(we," вошли в "));
        we.stayOn(anchor,"и встали на ");
        System.out.println(erebusImplSmoked.smoking(" курящегося "));

        outLine.lined(true, gigant);
        height.provide();
        me.remembered(engaving,fudzi," напомнили ");
        System.out.print(gigant.behind());
        TerrorImplExtinct.whiteing sth = () -> {
            TerrorImplExtinct.ghostly();
            return " белел ";
        };
        System.out.print(sth.reverse() );
        terrorImplExtinct.extincting("потухающий");
        System.out.println(height.equal(terrorImplExtinct));
    }
}
