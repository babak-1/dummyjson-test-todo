package com.babak.retrofitapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.babak.retrofitapi.databinding.FragmentAllTodosBinding
import com.babak.retrofitapi.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllTodosFragment : Fragment() {
    private var _binding: FragmentAllTodosBinding? = null
    private val binding get() = _binding!!
    private val api=ApitUtils.createApi()
    private val todoAdapter = TodoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =FragmentAllTodosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvAllTodos.adapter=todoAdapter
        api.getAllTodos().enqueue(object :Callback<AllTodosModel>{
            override fun onResponse(call: Call<AllTodosModel>, response: Response<AllTodosModel>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        it.todos?.let{todos->
                            todoAdapter.updateList(todos)
                    }
                    }
                }
            }

            override fun onFailure(call: Call<AllTodosModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}