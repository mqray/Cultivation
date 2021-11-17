public class FilterGenerator {

    public static void main(String[] args) {
        Node<String> x = new Node<String>("parent1");
        Node<String> y = new Node<String>("parent2");

        System.out.println(x.getRoot());

        Node<String> child1 = x.addChild("child1");
        {
            Node<String> innerChild1 = child1.addChild("innerChild1OfChild1");
            Node<String> innerChild2 = child1.addChild("innerChild2OfChild1");
            Node<String> innerChild3 = child1.addChild("innerChild3OfChild1");

            System.out.println("-" + child1);

            System.out.println("--" + innerChild1);
            System.out.println("--" + innerChild2);
            System.out.println("--" + innerChild3);

            System.out.println("Level of child1: " + child1.getLevel());
            System.out.println("Level of innerChild2 in Child1: " + innerChild2.getLevel());


        }
        System.out.println();

    }

}
