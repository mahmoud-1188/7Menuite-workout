package com.example.a7menuite_project

class exercisemodel(var id:Int , var name :String, var image:Int,var isselect:Boolean,var iscomplet : Boolean) {

    fun getid ():Int{
        return id
    }

    fun setid (id:Int){
        this.id = id
    }

    fun getname ():String{
        return name
    }

    fun setname (name:String){
        this.name = name
    }

    fun getimag ():Int{
        return image
    }

    fun setimage (image:Int){
        this.image = image
    }

    fun get_isselected ():Boolean{
        return isselect
    }

    fun set_isselected (isselected:Boolean){
        this.isselect = isselected
    }

    fun get_iscomplet ():Boolean{
        return iscomplet
    }

    fun set_iscomplet (iscomplet:Boolean){
        this.iscomplet = iscomplet
    }
}