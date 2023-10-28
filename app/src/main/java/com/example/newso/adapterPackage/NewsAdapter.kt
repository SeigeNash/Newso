package com.example.newso.adapterPackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import androidx.media3.common.util.Util
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newso.R
import com.example.newso.data.entity.entities.Article
//import com.google.firebase.firestore.util.Util
import kotlinx.android.synthetic.main.single_news.view.textTitle
import kotlinx.android.synthetic.main.single_news.view.txtdescription
import kotlinx.android.synthetic.main.single_news.view.txtpublishdate

//import com.example.package.path.Util
//import com.bumptech.glide.Glide

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    private val differntCallback = object : DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url;
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem;
        }

    }

    val differ = AsyncListDiffer( this, differntCallback );

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.single_news, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size;
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {

            //Glide.with(this).load( article.urlToImage).into(urltoImg)
            textTitle.text = article.title;
            txtdescription.text = article.description;
            txtpublishdate.text = article.publishedAt;

            setOnClickListener {
                onItemClickListener?.let {
                    it(article)
                }
            }

        }

    }

    private var onItemClickListener : ((Article) -> Unit )? = null              // private var onItemClickListener : ((Article) -> Util )? = null

    fun setOnClickListener( listener : (Article) -> Unit ){

        onItemClickListener = listener;
    }

}