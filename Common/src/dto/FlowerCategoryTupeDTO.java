package dto;

public class FlowerCategoryTupeDTO implements SuperDTO {
    private String id;
    private String name;

    public FlowerCategoryTupeDTO() {
    }

    public FlowerCategoryTupeDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FlowerCategoryTupeDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}


