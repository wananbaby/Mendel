public class String_gene {

    public String[] string_gene_1(String[] str_1,String[] str_2){

        String[] st_1 = str_1;
        String[] st_2 = str_2;
        if(st_1==null||st_1.length==0){
            return st_2;
        }if (st_2==null||st_2.length==0){
            return st_1;
        }else {
            int m=st_1.length;
            int n=st_2.length;
            String[] st_new_st = new String[m*n];
            int mn = 0;
            for(int i =0;i<m;i++){
                for (int j =0;j<n;j++){
                    st_new_st[mn] = st_1[i] + st_2[j];
                    mn++;
                }
            }
            return st_new_st;
        }
    }
}
