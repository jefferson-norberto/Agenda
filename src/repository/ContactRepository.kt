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

        }
    }

}