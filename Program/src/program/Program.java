/*John Lambrecht
Program1
5/15/19
It does what the instructions say it should
 */

package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        tree mytree;
        Scanner sc;
        try {
            sc = new Scanner(new File("input.txt"));
            while (sc.hasNextLine()) {
                String string = sc.nextLine();
                String [] splitstring = string.split(",");
                int[] split= new int[splitstring.length];
                for (int i = 0; i < splitstring.length; i++) {
                    split[i] = Integer.parseInt(splitstring[i]);
//                    System.out.println(split[i]);
                }
                int j = 0;
                mytree = new tree();
                while (j<split.length){
                    mytree.buildTree(split[j]);
                    j++;
                }
                int choice = 0;
                while (choice != -1){
                    System.out.println("What would you like to do?");
                    System.out.println("1 Would've been print tree, but couldn't figure it out");
                    System.out.println("Press 2 to insert a node");
                    System.out.println("Press 3 to delete a node");
                    System.out.println("Press 4 to search for a node");
                    System.out.println("Press 5 to print InOrder");
                    System.out.println("Press 6 to print PreOrder");
                    System.out.println("Press 7 to print PostOrder");
                    System.out.println("Press -1 to exit");
                    Scanner reader = new Scanner(System.in);
                    choice = reader.nextInt();
                    switch(choice){
                        case 1:
                            System.out.println("I tried to get tree printing to work, but couldn't figure it out");
                            break;
                        case 2:
                            System.out.println("Please enter the number to enter");
                            Scanner in = new Scanner(System.in);
                            int input = in.nextInt();
                            mytree.buildTree(input);
                            break;
                        case 3:
                            System.out.println("Enter the node you want to delete");
                            Scanner del = new Scanner(System.in);
                            Node delroot = mytree.getRoot();
                            Node delete = mytree.searchTree(delroot, del.nextInt());
                            mytree.delete(delete);
                            break;
                        case 4:
                            System.out.println("Please enter the number to search");
                            Scanner searchit = new Scanner(System.in);
                            int searchint = searchit.nextInt();
                            Node root = mytree.getRoot();
                            Node search = mytree.searchTree(root,searchint);
                            if (search == null){
                                System.out.println("The node is not in the tree");
                            }else{
                                System.out.println("The node is in the tree");
                            }
                            break;
                        case 5:
                            Node Inorderroot = mytree.getRoot();
                            mytree.InOrder(Inorderroot);
                            break;
                        case 6:
                            Node Preorderroot = mytree.getRoot();
                            mytree.PreOrder(Preorderroot);
                            break;
                        case 7:
                            Node Postorderroot = mytree.getRoot();
                            mytree.PostOrder(Postorderroot);
                            break;
                        case -1:
                            System.out.println("exit");
                            break;
                        default:
                            System.out.println("Invalid choice");
                            choice = 0;
                            break;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("file error");
        }

    }
}
