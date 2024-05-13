package com.babak.retrofitapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.babak.retrofitapi.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val api = ApitUtils.createApi()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        myVisibilty(true)
        super.onViewCreated(view, savedInstanceState)
        api.getTodo().enqueue(object : retrofit2.Callback<TodoModel> {
            override fun onResponse(call: Call<TodoModel>, response: Response<TodoModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        myVisibilty(false)
                        binding.todoCompleted.text = it.completed.toString()
                        binding.todoId.text = it.id.toString()
                        binding.todoText.text = it.todo.toString()
                        binding.todoUserId.text = it.userId.toString()
                    }
                }
            }

            override fun onFailure(call: Call<TodoModel>, t: Throwable) {
            }

        })


    }

    fun myVisibilty(checked: Boolean) {
        if (checked) {
            binding.todoCompleted.visibility = View.GONE
            binding.todoUserId.visibility = View.GONE
            binding.todoText.visibility = View.GONE
            binding.todoId.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.todoCompleted.visibility = View.VISIBLE
            binding.todoUserId.visibility = View.VISIBLE
            binding.todoText.visibility = View.VISIBLE
            binding.todoId.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}