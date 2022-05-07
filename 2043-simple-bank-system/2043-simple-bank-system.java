class Bank {
    long[] acc_balance;
    
    public Bank(long[] balance) {
        acc_balance=balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account2<=acc_balance.length && withdraw(account1,money)){
            return deposit(account2,money);
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account<=acc_balance.length){
            acc_balance[account-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(account<=acc_balance.length && acc_balance[account-1]>=money){
            acc_balance[account-1]-=money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */