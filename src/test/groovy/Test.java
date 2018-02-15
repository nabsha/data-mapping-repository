import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.nabsha.mapper.model.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nabsha_monash on 19/11/17.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(gen("/Users/nabsha_monash/work/other/data-mapping-repository/src/test/resources/mappings.txt")));
    }

    public static MappingSet gen(String fileName) throws IOException {
        MappingSet ms = new MappingSet("test", new LinkedList<>());

        File f = new File(fileName);
        List<String> strings = FileUtils.readLines(f, "UTF-8");

        for (String string: strings) {
            String[] toks = string.split(" ");
            String source = toks[0];
            String rule = toks[1];
            String dest = toks[2];

            String[] srcToks = source.split("@");
            LinkedList<ModelAttribute> srcModels = new LinkedList<>();
            ModelAttribute srcModel = new ModelAttribute(srcToks[0], new DomainModel(srcToks[1]));
            srcModels.add(srcModel);

            String[] dstToks = dest.split("@");
            ModelAttribute dstModel = new ModelAttribute(dstToks[0], new DomainModel(dstToks[1]));

            MappingRule mappingRule = new MappingRule(dstModel.getName(), srcModels, dstModel, rule);

            ms.getMappingRules().add(mappingRule);
        }

        return ms;
    }
}
