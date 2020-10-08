
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class Bloom {

    public static void main(String[] args) {
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);

        for (int i = 0; i < 5; i++) {
            bloomFilter.put(i);
        }

        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(100));
        System.out.println(bloomFilter.mightContain(5));

    }
}
