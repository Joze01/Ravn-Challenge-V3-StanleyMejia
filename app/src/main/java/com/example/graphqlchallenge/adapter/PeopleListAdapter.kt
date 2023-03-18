package com.example.graphqlchallenge.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.graphqlchallenge.DetailsActivity
import com.example.graphqlchallenge.PeopleListQuery
import com.example.graphqlchallenge.databinding.ItemCharacterBinding

class PeopleListAdapter(
): ListAdapter<PeopleListQuery.Person,ViewHolderList<*>>(DiffUtilCallback)  {

    private object DiffUtilCallback : DiffUtil.ItemCallback<PeopleListQuery.Person>() {
        override fun areItemsTheSame(oldItem: PeopleListQuery.Person, newItem: PeopleListQuery.Person): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: PeopleListQuery.Person, newItem: PeopleListQuery.Person): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList<*> {
        val itemBinding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolderList<*>, position: Int) {
        when (holder) {
            is BindViewHolder -> holder.bind(getItem(position), position)
        }
    }

    inner class BindViewHolder(private val binding: ItemCharacterBinding) : ViewHolderList<PeopleListQuery.Person>(binding.root) {

        override fun bind(item: PeopleListQuery.Person, position: Int) = with(binding) {
            characterName.text = item.name
            planet.text = item.homeworld!!.name
            gender.text = item.gender
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DetailsActivity::class.java)
                intent.putExtra("name", item.name)
                intent.putExtra("eyecolor", item.eyeColor)
                intent.putExtra("haircolor", item.hairColor)
                intent.putExtra("skincolor", item.skinColor)
                intent.putExtra("birthday", item.birthYear)
                binding.root.context.startActivity(intent)
            }
        }

        }

    }