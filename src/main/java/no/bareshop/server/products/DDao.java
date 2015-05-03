package no.bareshop.server.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kubilay on 30.04.2015.
 */
@Entity
@Table(name= "no/bareshop/server/products")
public class DDao {

        @Id
        @Column(name = "id")
        private int id;
        @Column(name = "name")
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;

        }
}
