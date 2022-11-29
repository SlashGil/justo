package com.justo.android.justotechnicaltest.ui.main.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justo.android.justotechnicaltest.R
import com.justo.android.justotechnicaltest.data.User
import com.justo.android.justotechnicaltest.databinding.UserItemBinding
import com.justo.android.justotechnicaltest.utils.inflate

class RandomUserAdapter(private val listener: UserItemListener) :
    RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder>() {

    interface UserItemListener {
        fun onClickedUser(user: User)
    }

    fun setItems(items: List<User>) {
        this.users.clear()
        this.users.addAll(items)
        notifyDataSetChanged()
    }

    private val users: MutableList<User> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder {
        val view = parent.inflate(R.layout.user_item, false)
        return RandomUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
        holder.binding.btnDetails.setOnClickListener {
            listener.onClickedUser(user)
        }
    }

    override fun getItemCount(): Int = users.size

    class RandomUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = UserItemBinding.bind(view)
        fun bind(user: User) = with(binding) {
            nameTxtContainer.text = user.name.toString()
            Glide.with(binding.root)
                .load(user.picture?.medium)
                .dontAnimate()
                .into(binding.thumbnailContainer)
        }
    }


}