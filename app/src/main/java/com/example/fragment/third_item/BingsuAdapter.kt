import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.fragment.Model.BingSu
import com.example.fragment.R
import com.example.fragment.databinding.ItemThirdBingsuBinding

class BingsuAdapter(private val imageUrls: List<BingSu>)
    : RecyclerView.Adapter<BingsuAdapter.BingsuViewHolder>() {

    class BingsuViewHolder(private val binding : ItemThirdBingsuBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.imgVBingSu
        val text : TextView = binding.tvBingSu
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BingsuViewHolder {
        val binding =ItemThirdBingsuBinding.inflate( LayoutInflater.from(parent.context), parent, false)
        return BingsuViewHolder(binding)
    }

    override fun getItemCount(): Int = imageUrls.size

    override fun onBindViewHolder(holder: BingsuViewHolder, position: Int) {
        val currentItem =imageUrls[position]
        holder.text.text = imageUrls[position].nBing
        Glide.with(holder.itemView.context)
            .load(currentItem.iUrl)
            .centerCrop()
            .into(holder.imageView)

    }

}
