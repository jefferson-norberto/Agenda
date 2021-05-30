/**
 * O repositorio é usado para realizar as funções de salvar/deletar/recuperar
 * as informações, podendo ser em uma variavel ou banco de dados
 * **/

package repository
import entity.ContactEntity

class ContactRepository {

    //usado para manter os dados durante a chamada de um novo MainForm
    //ao retornar da tela de Novo Contato para a Tela principal do programa
    companion object{
        val list = mutableListOf<ContactEntity>()

        fun save(contact: ContactEntity){
            list.add(contact)
        }

        fun remove(contact: ContactEntity){
            //list.remove(contact)
            for(item in list.withIndex()){
                if(item.value.name == contact.name && item.value.phone == contact.phone){
                    list.removeAt(item.index)
                    break
                }
            }

        }

        @JvmName("getListContacts")
        fun getList(): List<ContactEntity>{
            return list
        }
    }

}