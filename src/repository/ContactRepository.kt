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
            //list.remove(contact) não funciona pois
            //o espaço da memoria é diferente, não passa a mesma posição na memoria
            //por tanto só funciona buscando de forma manual

            var index :Int = 0
            for(item in list.withIndex()){
                if(item.value.name == contact.name && item.value.phone == contact.phone){
                    index = item.index
                    break
                }
            }
            list.removeAt(index)
        }

        @JvmName("getListContacts")
        fun getList(): List<ContactEntity>{
            return list
        }
    }

}