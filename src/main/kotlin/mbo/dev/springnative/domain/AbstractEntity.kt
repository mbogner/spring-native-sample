package mbo.dev.springnative.domain

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.util.ProxyUtils
import java.util.UUID

@MappedSuperclass
abstract class AbstractEntity(

    @Id
    @GeneratedValue(generator = "uuid")
    var id: UUID? = null

) {

    /**
     * id only check for jpa entity
     */
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false
        if (other !is AbstractEntity) return false
        if (null == id || id != other.id) return false
        return true
    }

    /**
     * @see <a href="https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier">external link</a>
     * for further infos why this is a static value.
     */
    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun toString(): String {
        return "${javaClass.simpleName}[id=${id}]"
    }

}
