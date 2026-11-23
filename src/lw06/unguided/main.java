package lw6.guided6a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree bst = new BinarySearchTree();

        String numbers = read.nextLine();
        Scanner numberRead = new Scanner(numbers);

        while (numberRead.hasNextInt()) {
            int data = numberRead.nextInt();
            bst.insert(data);
        }

        int target = read.nextInt();

        System.out.print("Preorder : ");
        bst.preOrder();

        System.out.print("Inorder : ");
        bst.inOrder();

        System.out.print("Postorder : ");
        bst.postOrder();

        System.out.println("Search " + target + " : " + bst.search(target));

        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum : " + bst.findMax());

        numberRead.close();
        read.close();
    }
}
