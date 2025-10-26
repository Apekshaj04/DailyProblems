class Bank {
    long[] b ;
    int n;

    public Bank(long[] balance) {
        n = balance.length;
        b = balance;  
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1<1 || account1>n || account2<1 || account2>n){
            return false;
        }
        long balance = b[account1-1];
        if(balance<money) return false;
        b[account2-1] = b[account2-1]+money;
        b[account1-1] = b[account1-1]-money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account>n || account<1) return false;
        b[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account>n || account<1) return false;
        if(b[account-1]<money) return false;
        b[account-1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */