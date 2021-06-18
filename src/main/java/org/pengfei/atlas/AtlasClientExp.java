package org.pengfei.atlas;

import org.apache.atlas.AtlasClientV2;
import org.apache.atlas.AtlasServiceException;
import org.apache.atlas.model.instance.AtlasEntity;
import org.apache.atlas.model.instance.AtlasEntityHeader;
import org.apache.atlas.model.instance.EntityMutationResponse;
import org.apache.atlas.type.AtlasType;


import java.util.List;

public class AtlasClientExp {

    private final AtlasClientV2 atlasClient;

     AtlasClientExp() {
        atlasClient = new AtlasClientV2(new String[]{"http://localhost:21000"}, new String[]{"admin", "admin"});
    }

    private void listTypes() throws AtlasServiceException {
        System.out.println("Types registered with Atlas:");
        List<String> types = atlasClient.getAllTypeDefs();
        for (String type : types) {
            System.out.println("Type: " + type);
        }
    }


    private void retrieveEntity(String guid) throws AtlasServiceException {
        System.out.println("Retrieving entity with GUID: " + guid);
        // AtlasEntity is from org.apache.atlas.model.instance
        AtlasEntity.AtlasEntityWithExtInfo entity = atlasClient.getEntityByGuid(guid);
        String entityJson = AtlasType.toV1Json(entity);
        System.out.println(entityJson);
    }

    private String createAvroEntity()
            throws AtlasServiceException {

        Referenceable referenceable = new Referenceable("avro_schema");
        referenceable.set("name", "testt-schema-v1");
        referenceable.set("description", "desc");
        referenceable.set("owner", "himani");
        referenceable.set("locationUri", "test-schema-v1");
        referenceable.set("type", "avro");
        referenceable.set("namespace", "com.knoldus");
        referenceable.set("createTime", System.currentTimeMillis());
        referenceable.set("qualifiedName", "test-avro-schema-v1");
        referenceable.set("avro_notation", "{ \"type\": \"record\", \"name\": \"testKey\", \"namespace\": \"key.test\", \"fields\": [{ \"name\": \"name\", \"type\": { \"type\": \"string\", \"logicalType\": \"CHARACTER\", \"dbColumnName\": \"name\", \"length\": 2 }, \"default\": \"\" }] }");

        String entityJSON = AtlasType.toV1Json(referenceable);
        System.out.println("Submitting new entity= " + entityJSON);
        List<String> entitiesCreated = atlasClient.create(entityJSON);

        System.out.println("created instance for type " + "avro" + ", guid: " + entitiesCreated);
        for (String entity : entitiesCreated) {
            System.out.println("Entity created: " + entity);
        }
        return entitiesCreated.get(entitiesCreated.size() - 1);
    }

    private List<AtlasEntityHeader> deleteEntity(String guid) throws AtlasServiceException {
        EntityMutationResponse response = atlasClient.deleteEntityByGuid(guid);
        return response.getDeletedEntities();
    }
}
}
