import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.fragment.R

class BingsuAdapter(private val imageUrls: MutableList<String>, private val viewPager2: ViewPager2)
    : RecyclerView.Adapter<BingsuAdapter.BingsuViewHolder>() {

    class BingsuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BingsuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.third_bingsu, parent, false)
        return BingsuViewHolder(view)
    }

    override fun getItemCount(): Int = imageUrls.size

    override fun onBindViewHolder(holder: BingsuViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(imageUrls[position])
            .into(holder.imageView)

        if (position == imageUrls.size - 1) {
            viewPager2.post(runnable)
        }
    }

    private val runnable = Runnable {
        val originalSize = imageUrls.size
        imageUrls.addAll(imageUrls.subList(0, 7))
        notifyItemRangeInserted(originalSize, 7)
    }
}
