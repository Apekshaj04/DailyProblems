class Solution {
    public int totalMoney(int n) {
            int m = n/7;
            int firstTerm = m*7*8/2;
            int secondTerm = 0;
            for(int i = 1;i<=m-1;i++){
                secondTerm += (m-i)*i;
            }
            int thirdTerm  =0 ;
            for(int i = 1;i<=m;i++){
                thirdTerm += (7+i)*(m-i);
            }
            int rem = n%7;
            int remTerm = 0;
            for(int i = 1;i<=rem;i++){
                remTerm += m+i;
            }
            System.out.println(firstTerm+" " + secondTerm+" "+ thirdTerm + " "+remTerm);
            return firstTerm - secondTerm +thirdTerm +remTerm;
    }
}