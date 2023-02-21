public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        String a[] = {"Willy-nilly, this semester I will learn"};
        int n = (int) (Math.random() * 1_000_000);
        int suma=0;
        n=n*3;
        n=n+0b10101;
        n=n+0xFF;
        n=n*6;
        while(n>0)
        {suma=suma+n%10;
            n=n/10;
        }
        while(suma>9)
        {  int aux=suma;
            int suma1=0;
            while(aux>0){
                suma1=suma1+aux%10;
                aux=aux/10;
            }
            suma=suma1;
        }
        System.out.println(suma);
        System.out.println(a[0]);
        System.out.println(languages[suma]);

    }
}
