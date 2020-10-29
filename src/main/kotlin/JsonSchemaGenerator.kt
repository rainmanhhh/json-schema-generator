import com.github.victools.jsonschema.generator.OptionPreset
import com.github.victools.jsonschema.generator.SchemaGenerator
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder
import com.github.victools.jsonschema.generator.SchemaVersion
import java.io.File

/**
 * args: targetClassName, outputJsonFilePath
 */
class JsonSchemaGenerator {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val configBuilder = SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
      // apply your configurations here
      val generator = SchemaGenerator(configBuilder.build())
      // target the class for which to generate a schema
      val targetClass = Class.forName(args[0])
      val jsonSchema = generator.generateSchema(targetClass)
      // handle generated schema, e.g. write it to the console or a file
      val jsonSchemaAsString = jsonSchema.toPrettyString()
      File(args[1]).writeText(jsonSchemaAsString)
    }
  }
}
