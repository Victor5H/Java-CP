package daily.TwentySix.twentyNinth;

public class PrimeNumberCheck {
    public boolean isPrime(long n){
        if(n<=1) return false;
        if(n<=3) return true;
        for(long i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
