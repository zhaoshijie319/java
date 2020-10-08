import com.google.common.collect.Lists;
import lombok.Data;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum FactorType {
    PERSON(Lists.newArrayList(new Index("za_person_base_info", "person"))),
    PLACE(Lists.newArrayList(new Index("za_building_residence_info", "building"),
        new Index("za_place_info", "place"))),
    EVENT(Lists.newArrayList(new Index("za_warning_instance_info", "warning"),
        new Index("za_case_instance_info", "case"))),
    THING(Lists.newArrayList(new Index("za_vehicle_info", "car"),
        new Index("za_device_info", "device"))),
    ORGANIZATION(Lists.newArrayList(new Index("za_reation_industry_unit", "reation")));

    private final List<Index> indexs;

    FactorType(List<Index> indexs) {
        this.indexs = indexs;
    }

    public List<Index> getIndexs() {
        return indexs;
    }

    public static Map<String, String> keys(List<String> factor) {
        Map<String, String> map = new HashMap<>();
        for (String f : factor) {
            List<Index> indexs = FactorType.valueOf(f).getIndexs();
            indexs.forEach(index -> map.put(index.index, index.type));
        }
        return map;
    }

    @Data
    public static class Index {
        private String index;
        private String type;

        public Index(String index, String type) {
            this.index = index;
            this.type = type;
        }
    }
}
