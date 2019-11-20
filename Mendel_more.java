import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mendel_more {
    public String father_more = null;
    public String mother_more = null;
    public String gene_base_more = null;

    protected String[] more_f = null;
    protected String[] more_m = null;
    protected String[] more_g = null;
    public List list =new ArrayList();//子代基因所有组合列表

    public Map show_map =new HashMap();
    public int map_lang = 0;//map长度

    public static void Mendel_more(){
    }

    public void setFather_more(String father_more) {
        this.father_more = father_more;
        //int k=0;
//        if(father_more.length()%2==0){
//            k = father_more.length()/2;
//        }else {
//            k = 1+father_more.length()/2;
//        }
        int k = father_more.length();
        more_f = father_more.split(",",k/2);
        //System.out.println(more_f.length);

    }

    public void setMother_more(String mother_more) {
        this.mother_more = mother_more;
        //int k=0;
//        if(mother_more.length()%2==0){
//            k = mother_more.length()/2;
//        }else {
//            k = 1+mother_more.length()/2;
//        }
        int k =mother_more.length();
        more_m = mother_more.split(",",k/2);
    }

    public void setGene_base_more(String gene_base_more) {
        this.gene_base_more = gene_base_more;
        //int k=0;
//        if(gene_base_more.length()%2==0){
//            k = 1+gene_base_more.length()/2;
//        }else {
//            k = gene_base_more.length()/2;
//        }
        int k =gene_base_more.length();
        more_g = gene_base_more.split(",",k/2);
    }

    public void Mendel_more_main1(){

        int k = more_m.length;
        map_lang = k;
        //System.out.println(k);
        for (int i =0;i<k;i++){
            Mendel mendel = new Mendel();
            Map map =new HashMap();
            map = mendel.Mendel_main(more_f[i],more_m[i],more_g[i]);
            show_map.put(i,mendel.st_g);

//            System.out.println(more_f[i]);
//            System.out.println(more_m[i]);
//            System.out.println(more_g[i]);
//            System.out.println("****************");

            String[] lin_st = mendel.st_new;//获取子代基因所有组合
            list.add(lin_st);
        }
    }

    public String[] gene_com(){//所有基因组
        // 需要重写

//        int k = list.size();
//        int num=0;
//        String[] st_test = {};
//        String[] st_test1 = (String[]) list.get(0);
//        int h = 1;
//        for (int i=0;i<k;i++){
//            int k_1 =st_test1.length;
//            for(int j=0;j<k_1;k++){
//                String[] st_test2 = (String[]) list.get(h);
//
//                int k_2 = st_test2.length;
//
//                for (int a =0;a<k_2;k++){
//                    st_test[j+a] = st_test1[j]+st_test2[a];
//                    h++;
//                    st_test1=st_test;
//                }
//            }
//        }
//     return  st_test;
        String[] st= {};
        int k = list.size();
        if(k==1){
           st = (String[]) list.get(0);
        }
        else {
            String[] st_one = (String[]) list.get(0);
            String[] st_second ={};
            String[] st_last= {};

            // 测试
//            int t1 =st_one.length;
//            //System.out.println(t1);
//            for (int t1_1=0;t1_1<t1;t1_1++){
//                System.out.println(st_one[t1_1]);
//                System.out.println("---------");
//                System.out.println(st_second[t1_1]);
//                System.out.println("-------------");
//            }
//            System.out.println("----------------------------");
            // 测试结束
            //int g = 1;
            String_gene string_gene = new String_gene();
            for (int i =1;i<k;i++){
                st_second = (String[]) list.get(i);
                String[] strings = string_gene.string_gene_1(st_one,st_second);
                st_last=strings;
                st_one=st_last;

                //
            }
            st=st_last;
        }
        return st;
    }

    public Map gene_com_bi(String[] gene_come){

        Map map = new HashMap();

        String[] st_1 = gene_come;

        int k =0;
        int h =st_1.length;
        for (int i=0;i<h;i++){
            String  st_2 = st_1[i];
            int v = 0;
            //判断这个基因组合方式在所有组合中的数量；
            for (int j=0;j<h;j++){
                if(st_1[j].equals(st_2)){
                    v++;
                }
            }
            //添加到基因组合树里
            if(map.get(st_2)==null){
                map.put(st_2,v);
            }
        }

        return map;
    }

    public Map gene_bi(String[] gene_come){
        Map this_map = show_map;
        String[] st_last ={};
        int g_lang =map_lang;
        String_gene string_gene = new String_gene();
        for (int i =0;i<g_lang;i++){
            String[] str = (String[]) this_map.get(i);
            st_last=string_gene.string_gene_1(st_last,str);
        }
        int st_lang = st_last.length;
        String[] str_1 = new String[gene_come.length];
        int[] ints = new int[st_lang];
        int gene_come_lang = gene_come.length;
        for (int i=0;i<gene_come_lang;i++){
            String st_1 =gene_come[i];
            //System.out.println(st_1);
            String[] st_2 = st_1.split("");
            String st_3 ="";// 得到的表现型组合
            for (int j=0;j< st_2.length;j++){
                if (j%2==1) {
                    continue;
                }
                if (j%2==0){
                    st_3 = st_3 + st_2[j];
                }
            }
            str_1[i] = st_3;
        }
        //测试
//        for (int i=0;i<str_1.length;i++){
//            System.out.println(str_1[i]);
//        }
        //
        for (int i =0;i<st_lang;i++){
            String string = st_last[i];
            int ints_v=0;
            for (int j=0;j<str_1.length;j++){

                if(str_1[j].equals(string)){
                    ints_v++;
                }
            }
            ints[i] = ints_v;
        }
        Map map =new HashMap();
        for (int i=0;i<st_last.length;i++){
            map.put(st_last[i],ints[i]);
        }

        return map;
    }
}
