import java.util.HashMap;
import java.util.Map;

public class Mendel {

    public String father=null;//父代基因(Aa)
    public String mother=null;//母带基因(Aa)
    public String gene_base =null;//性状比（A:a）这里是绝对显隐性。

    protected String[] st_f = new String[2];
    protected String[] st_m = new String[2];
    protected String[] st_g = new String[2];


    public static void Mendel(){

    }
    public Map Mendel_main(String father, String mother, String gene_base){
        st_f = father.split("");
        st_m = mother.split("");
        st_g = gene_base.split(",");
//        System.out.println(st_g.length);
//        System.out.println(st_g[1]);

        String[] st_new = new String[4];
        // 所有基因组合，可重复
        int iii=0;
        for (int i =0;i<2;i++){
            for (int j =0;j<2;j++){

                if(i>j){
                    st_new[iii] = st_m[j] + st_f[i];
                    iii++;
                }else {
                    st_new[iii] = st_f[i] + st_m[j];
                    iii++;
                }
            }
        }

        //性状比
        Map map_son_bi = new HashMap();
        map_son_bi.put(st_g[0],0);
        map_son_bi.put(st_g[1],0);

        for (int k=0;k<4;k++){
            if(st_new[k].contains(st_g[0])){
                // 值加1
                map_son_bi.put(st_g[0],(int)(map_son_bi.get(st_g[0]))+1);
                continue;
            }else {
                if(st_new[k].contains(st_g[1])){
                    map_son_bi.put(st_g[1],(int)(map_son_bi.get(st_g[1]))+1);
                }
            }
        }

        //返回数据
        Map map =new HashMap();

        map.put(st_new,map_son_bi);

        return map;
    }
}
