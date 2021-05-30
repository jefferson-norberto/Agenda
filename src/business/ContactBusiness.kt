/**
 * No business fica alocado as regras de négiocos
 * então a validação dos dados ocorrem nessa classe
 * **/

package business
import entity.ContactEntity
import repository.ContactRepository

class ContactBusiness {
    fun save(name :String, phone :String){
        validate(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.save(contact)
    }

    fun remove(name: String, phone: String){
        validadeRemove(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.remove(contact)
    }

    private fun validate(name: String, phone: String){
        if(name == ""){
            throw Exception("Nome é obrigatório!")

        }
        if(phone == ""){
            throw java.lang.Exception("Telefone é obrigatório!")
        }
    }

    private fun validadeRemove(name: String, phone: String){
        if(name == "" || phone == ""){
            throw java.lang.Exception("Selecione um contato primeiro!")
        }
    }

    fun getList(): List<ContactEntity> {
        return ContactRepository.getList()
    }

    fun getContactCountDescription(): String{
        val list = getList()

        val retorno = when{
            list.isEmpty() -> "0 contatos"
            list.size == 1 -> "1 contato"
            else -> "${list.size} contatos"
        }

        return retorno
    }
}