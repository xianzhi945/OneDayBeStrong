package radix;
import java.util.*;

class RadixNode {
    int value;
    Map<Integer, RadixNode> children;

    public RadixNode() {
        children = new HashMap<>();
    }
}

class RadixTree {
    private RadixNode root;

    public RadixTree() {
        root = new RadixNode();
    }

    public void insert(String cidr) {
        // 将CIDR格式切分成ip部分和网络地址的位数
        String[] parts = cidr.split("/");
        String[] ipParts = parts[0].split("\\.");

        // 网络地址的位数
        int prefixLength = Integer.parseInt(parts[1]);
        // 获取mask
        int mask = 0xffffffff << (32 - prefixLength);

        RadixNode node = root;
        for (int i = 0; i < ipParts.length; i++) {
            // 对IP进行切分，每个元素都表示ip的一部分值
            int b = Integer.parseInt(ipParts[i]);
            int shift = 24 - 8 * i;
            // 将每一部分进行移位 b & 0xff 更好的办法是和mask进行对应匹配
            int key = (b & 0xff) << shift;

            RadixNode child = node.children.get(key);
            if (child == null) {
                child = new RadixNode();
                node.children.put(key, child);
            }
            node = child;
        }
        node.value = mask;
    }

    public int match(String ip) {
        String[] ipParts = ip.split("\\.");

        RadixNode node = root;
        for (int i = 0; i < ipParts.length; i++) {
            int b = Integer.parseInt(ipParts[i]);
            int shift = 24 - 8 * i;
            int key = (b & 0xff) << shift;

            RadixNode child = node.children.get(key);
            if (child == null) {
                return 0;
            }
            node = child;
        }
        return node.value;
    }
}