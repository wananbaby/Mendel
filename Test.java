import java.util.Map;

public class Test {

    public static void main(String[] args) {

        Mendel_more mendel_more = new Mendel_more();

        mendel_more.setFather_more("Aa,Bb,Cc,Dd,Ee,Ff,Gg,Hh,Ii,Jj,Kk,Ll");
        mendel_more.setMother_more("Aa,Bb,Cc,Dd,Ee,Ff,Gg,Hh,Ii,Jj,Kk,Ll");
        mendel_more.setGene_base_more("Aa,Bb,Cc,Dd,Ee,Ff,Gg,Hh,Ii,Jj,Kk,Ll");

        mendel_more.Mendel_more_main1();

        String[] st_test = mendel_more.gene_com();
        int v = st_test.length;
        for (int i=0;i<v;i++){
            System.out.printf("|");
            System.out.printf(st_test[i]);
            System.out.println("|");
        }
        System.out.println("----------------------------");
        Map map = mendel_more.gene_com_bi(st_test);
        System.out.println(map);
        System.out.println("----------------------------");
        Map map1 = mendel_more.gene_bi(st_test);
        System.out.println(map1);
    }
}
