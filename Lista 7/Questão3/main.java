package Questão3;

public class main {
         public static void main(String[] args){

        Livro l = new Livro("O Senhor dos Aneis", "J.R.R. Tolkien", 1000, 1954);
        LivroLivraria ll = new LivroLivraria("O Senhor dos Aneis", "J.R.R. Tolkien", 1000, 1954, 100, 10);
         System.out.println(l.isOlder());

            System.out.println(ll.isOlder());
            System.out.println(ll.toString());

            

    }
}
