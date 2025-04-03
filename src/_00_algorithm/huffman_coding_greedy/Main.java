package _00_algorithm.huffman_coding_greedy;

class Main {
    public static void main(String[] args) throws Exception{
        String str = "racer";
        HuffmanCoder hf = new HuffmanCoder(str);
        String cs = hf.encode(str);
        System.out.println(cs);
        String dc = hf.decode(cs);
        System.out.println(dc);
    }
}
